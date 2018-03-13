package com.technocratos.graphapisample.di.component

import com.technocratos.graphapisample.app.App
import com.technocratos.graphapisample.di.module.AppAndroidModule
import com.technocratos.graphapisample.di.module.AppModule
import com.technocratos.graphapisample.di.scope.Singleton
import dagger.Component
import dagger.android.AndroidInjector

@Singleton
@Component(modules = [AppAndroidModule::class, AppModule::class])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}