package com.technocratos.graphapisample.di.module

import com.technocratos.graphapisample.main.activities.MainActivity
import com.technocratos.graphapisample.auth.activities.LoginActivity
import com.technocratos.graphapisample.auth.activities.SignUpActivity
import com.technocratos.graphapisample.auth.activities.StartActivity
import com.technocratos.graphapisample.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface AppAndroidModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    fun mainActivityInjector() : MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [StartModule::class])
    fun startActivityInjector() : StartActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    fun loginActivityInjector() : LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    fun signUpActivity() : SignUpActivity

}