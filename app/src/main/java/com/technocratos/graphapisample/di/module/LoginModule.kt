package com.technocratos.graphapisample.di.module

import com.technocratos.graphapisample.auth.activities.LoginActivity
import com.technocratos.graphapisample.auth.view.LoginView
import com.technocratos.graphapisample.di.scope.ActivityScope

import dagger.Binds
import dagger.Module

@Module
interface LoginModule {
    @Binds
    @ActivityScope
    fun provideView(activity : LoginActivity): LoginView
}
