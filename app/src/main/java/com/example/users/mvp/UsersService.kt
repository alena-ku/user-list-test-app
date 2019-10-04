package com.example.users.mvp

import com.example.users.app.UsersApi
import com.example.users.mvp.models.User
import io.reactivex.Observable

class UsersService(private val usersApi: UsersApi) {

    fun getUses(): Observable<List<User>> {
        return usersApi.requestUsersInfo()
            .map(UsersResponse::data)
    }
}