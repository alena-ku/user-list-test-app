package com.example.users.mvp.presenters

import com.example.users.app.App
import com.example.users.mvp.UsersService
import com.example.users.mvp.models.User
import com.example.users.mvp.views.UsersView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class UsersPresenter : MvpPresenter<UsersView>() {

    @Inject
    lateinit var usersService: UsersService

    init {
        App.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val users = listOf(
            User(1, "Name1","Surname1"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(2, "Name2","Surname2"),
            User(3, "Name3","Surname3")
        )
        viewState.updateUsers(users);
    }

    fun onUserClick(user: User) {
        viewState.openUserDetails(user.id)
    }
}
