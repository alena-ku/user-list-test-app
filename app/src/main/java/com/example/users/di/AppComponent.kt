package com.example.users.di

import android.content.Context
import com.example.users.app.App
import com.example.users.di.modules.AppModule
import com.example.users.di.modules.ViewsModule
import com.example.users.mvp.presenters.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ViewsModule::class
])
interface AppComponent : AndroidInjector<App>  {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
        @BindsInstance
        fun applicationContext(context: Context): Builder
    }

    fun inject(usersPresenter: UsersPresenter)

}