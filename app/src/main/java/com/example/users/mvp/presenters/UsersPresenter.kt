package com.example.users.mvp.presenters

import com.example.users.mvp.models.User
import com.example.users.mvp.views.UsersView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class UsersPresenter constructor(
) : MvpPresenter<UsersView>() {

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
