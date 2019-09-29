package com.example.users.mvp.views

import com.example.users.mvp.models.User
import moxy.MvpView

interface UsersView : MvpView{
    fun openUserDetails(userId: Int)
    fun updateUsers(userNames: List<User>)
}
