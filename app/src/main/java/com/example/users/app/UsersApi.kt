package com.example.users.app

import com.example.users.mvp.models.UsersResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {
    @GET("users")
    fun requestUsersInfo(@Query("page") page: Int): Single<UsersResponse>
}