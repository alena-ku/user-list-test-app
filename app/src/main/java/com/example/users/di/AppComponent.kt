package com.example.users.di

import android.app.Application
import com.example.users.app.App
import com.example.users.di.modules.UsersServiceModule
import com.example.users.di.modules.ViewsModule
import com.example.users.mvp.presenters.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ViewsModule::class, UsersServiceModule::class])
interface AppComponent : AndroidInjector<App>  {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
        @BindsInstance
        fun application(application: Application): Builder
    }

    fun inject(usersPresenter: UsersPresenter)

}