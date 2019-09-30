package com.example.users.di.modules

import com.example.users.ui.activities.MainActivity
import com.example.users.ui.fragments.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Abstract class to specify the activities in which Dependencies need to be injected
 */
@Module
abstract class ViewsModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeUsersFragment(): UsersFragment

}