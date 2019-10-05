package com.example.users.mvp.views

import com.example.users.mvp.models.User
import moxy.MvpView

interface UserDetailsView : MvpView{
    fun updateUserDetails(user: User)
}
