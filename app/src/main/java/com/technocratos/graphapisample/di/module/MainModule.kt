package com.technocratos.graphapisample.di.module

import com.technocratos.graphapisample.di.scope.ActivityScope
import com.technocratos.graphapisample.main.activities.MainActivity
import com.technocratos.graphapisample.main.view.MainView
import dagger.Binds
import dagger.Module

@Module
interface MainModule {
    @ActivityScope
    @Binds
    fun provideView(activity: MainActivity): MainView
}