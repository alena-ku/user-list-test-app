package com.example.users.mvp

import com.example.users.app.UsersApi
import com.example.users.mvp.models.User
import rx.Observable

class UsersService(private val usersApi: UsersApi) {

    fun getUses(): Observable<List<User>> {
        return usersApi.users
    }
}