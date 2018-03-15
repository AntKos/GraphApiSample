package com.technocratos.graphapisample.di.module

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.technocratos.graphapisample.app.App
import com.technocratos.graphapisample.base.AppPreferences
import com.technocratos.graphapisample.di.scope.Singleton
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: App): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideOkHttp(@Named("LOGGER") interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    @Named("BASE_URL")
    fun provideBaseUrl(): String {
        return "https://graphtest.hippyfizz.business/graphql"
    }

    @Provides
    @Singleton
    @Named("LOGGER")
    fun provideLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideApollo(@Named("BASE_URL") url: String, okHttpClient: OkHttpClient): ApolloClient {
        return ApolloClient.builder().okHttpClient(okHttpClient).serverUrl(url).build()
    }

    @Provides
    @Singleton
    fun provideAppPreferences(context: Context): AppPreferences {
        return AppPreferences(context)
    }
}