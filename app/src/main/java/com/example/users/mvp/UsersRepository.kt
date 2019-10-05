package com.example.users.mvp

import com.example.users.app.UsersApi
import com.example.users.data.AppDatabase
import com.example.users.mvp.models.User
import io.reactivex.Completable
import io.reactivex.Flowable

class UsersRepository(
    private val usersApi: UsersApi,
    private val appDatabase: AppDatabase) {

    fun getUser(userId: Int): Flowable<User>
            = appDatabase.userDao().getById(userId)

    fun refresh() : Completable {
        return usersApi.requestUsersInfo(1)
            .map {appDatabase.userDao().replaceAll(it.data)}
            .ignoreElement()
    }

    fun getCachedUsers(): Flowable<List<User>> {
        return appDatabase.userDao().getAll()
    }
}