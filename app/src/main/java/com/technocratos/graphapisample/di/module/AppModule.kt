package com.technocratos.graphapisample.di.module

import android.content.Context
import com.technocratos.graphapisample.app.App
import com.technocratos.graphapisample.di.scope.Singleton
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app : App) : Context {
        return app.applicationContext
    }
}