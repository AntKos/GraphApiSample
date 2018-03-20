package com.technocratos.graphapisample.di.module

import com.technocratos.graphapisample.auth.activities.StartActivity
import com.technocratos.graphapisample.auth.view.StartView
import com.technocratos.graphapisample.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
interface StartModule {
    @ActivityScope
    @Binds
    fun provideStartActivity(activity : StartActivity) : StartView
}