package com.example.users.app;

import com.example.users.mvp.UsersResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UsersApi {
	@GET("users")
	Observable<UsersResponse> requestUsersInfo();
}
