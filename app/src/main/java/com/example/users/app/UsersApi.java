package com.example.users.app;

import com.example.users.mvp.models.User;
import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

public interface UsersApi {
	@GET("/users")
	Observable<List<User>> getUsers();
}
