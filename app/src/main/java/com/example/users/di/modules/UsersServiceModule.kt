package com.example.users.di.modules

import com.example.users.app.UsersApi
import com.example.users.mvp.UsersService
import com.example.users.mvp.models.User
import com.google.gson.FieldNamingPolicy
import com.google.gson.FieldNamingStrategy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import rx.schedulers.Schedulers
import java.lang.reflect.Field
import javax.inject.Singleton

@Module
class UsersServiceModule {

    @Provides
    @Singleton
    fun provideUsersService(usersApi: UsersApi): UsersService {
        return UsersService(usersApi)
    }

    @Provides
    @Singleton
    fun provideUsersApi(retrofit: Retrofit): UsersApi {
        return retrofit.create(UsersApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl("https://reqres.in/api/").build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(converterFactory: Converter.Factory): Retrofit.Builder {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(converterFactory)
    }

    @Provides
    @Singleton
    fun provideConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            //.setFieldNamingStrategy(CustomFieldNamingPolicy())
            .setPrettyPrinting()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .serializeNulls()
            .create()
    }

//    private class CustomFieldNamingPolicy : FieldNamingStrategy {
//        override fun translateName(field: Field): String {
//            var name = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES.translateName(field)
//            name = name.substring(2, name.length).toLowerCase()
//            return name
//        }
//    }
}