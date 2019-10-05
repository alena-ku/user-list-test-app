package com.example.users.mvp.presenters

import com.example.users.app.App
import com.example.users.mvp.UsersRepository
import com.example.users.mvp.models.User
import com.example.users.mvp.views.UsersView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class UsersPresenter : BasePresenter<UsersView>() {

    @Inject
    lateinit var usersRepository: UsersRepository

    init {
        App.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        unsubscribeOnDestroy(
            usersRepository.getCachedUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::updateUsers)
        )

        viewState.toggleLoading(true)

        unsubscribeOnDestroy(
            usersRepository.refresh()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.toggleLoading(false)
                }, { error ->
                    viewState.loadingFailed(error.localizedMessage)
                    viewState.toggleLoading(false)
                })
        )
    }

    fun onUserClick(user: User) {
        viewState.openUserDetails(user)
    }
}
