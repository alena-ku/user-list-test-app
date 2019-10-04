package com.example.users.mvp.presenters

import android.util.Log
import com.example.users.app.App
import com.example.users.mvp.UsersService
import com.example.users.mvp.models.User
import com.example.users.mvp.views.UsersView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class UsersPresenter : BasePresenter<UsersView>() {

    @Inject
    lateinit var usersService: UsersService

    init {
        App.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.toggleLoading(true)

        val observable = usersService.getUses()

        val subscription = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ users ->
                viewState.updateUsers(users);
                viewState.toggleLoading(false)
            }, { error ->
                viewState.toggleLoading(false)
                viewState.loadingFailed(error.localizedMessage)
            })

        unsubscribeOnDestroy(subscription)
    }

    fun onUserClick(user: User) {
        viewState.openUserDetails(user.id)
    }
}
