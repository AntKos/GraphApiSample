package com.technocratos.graphapisample.di.module

import com.technocratos.graphapisample.auth.activities.SignUpActivity
import com.technocratos.graphapisample.auth.view.SignUpView
import com.technocratos.graphapisample.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
interface SignUpModule {
    @ActivityScope
    @Binds
    fun provideSignUpView(activity : SignUpActivity) : SignUpView
}