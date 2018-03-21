package com.technocratos.graphapisample.app

import com.technocratos.graphapisample.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    companion object {
        var appComponent : DaggerAppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().create(this) as DaggerAppComponent
        }
        return appComponent as DaggerAppComponent
    }

}
