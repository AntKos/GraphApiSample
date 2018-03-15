package com.technocratos.graphapisample.di.module

import com.technocratos.graphapisample.auth.MainActivity
import com.technocratos.graphapisample.auth.activities.LoginActivity
import com.technocratos.graphapisample.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface AppAndroidModule {
    @ActivityScope
    @ContributesAndroidInjector
    fun mainActivityInjector() : MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    fun loginActivityInjector() : LoginActivity
}