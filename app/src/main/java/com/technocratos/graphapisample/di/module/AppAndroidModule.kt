package com.technocratos.graphapisample.di.module

import android.content.Context
import com.technocratos.graphapisample.app.App
import com.technocratos.graphapisample.auth.MainActivity
import com.technocratos.graphapisample.di.scope.ActivityScope
import com.technocratos.graphapisample.di.scope.Singleton
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface AppAndroidModule {
    @ActivityScope
    @ContributesAndroidInjector
    fun mainActivityInjector() : MainActivity
}