package com.example.users.mvp.presenters

import com.example.users.app.App
import com.example.users.mvp.UsersRepository
import com.example.users.mvp.views.UserDetailsView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class UserDetailsPresenter(private val userId: Int)
    : BasePresenter<UserDetailsView>() {

    @Inject
    lateinit var usersRepository: UsersRepository

    init {
        App.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        unsubscribeOnDestroy(
            usersRepository.getUser(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::updateUserDetails)
        )
    }
}
