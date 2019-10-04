package com.example.users.mvp.views

import com.example.users.mvp.models.User
import moxy.MvpView

interface UsersView : MvpView{
    fun toggleLoading(loading: Boolean)
    fun updateUsers(userNames: List<User>)
    fun openUserDetails(user: User)
    fun loadingFailed(message: String)
}
