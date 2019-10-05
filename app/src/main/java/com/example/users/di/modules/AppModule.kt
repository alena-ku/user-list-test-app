package com.example.users.di.modules

import android.content.Context
import androidx.room.Room
import com.example.users.app.UsersApi
import com.example.users.data.AppDatabase
import com.example.users.mvp.UsersRepository
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context) : AppDatabase
            = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "users.db"
    ).build()

    @Provides
    @Singleton
    fun provideUsersRepository(usersApi: UsersApi, appDatabase: AppDatabase): UsersRepository {
        return UsersRepository(usersApi, appDatabase)
    }

    @Provides
    @Singleton
    fun provideUsersApi(retrofit: Retrofit): UsersApi {
        return retrofit.create(UsersApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}