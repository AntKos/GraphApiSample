package com.technocratos.graphapisample.di.module

import android.content.Context
import android.util.Log
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
    fun provideOkHttp(@Named("LOGGER") loggingInterceptor: Interceptor,
                      @Named("AUTHORIZATOR") authInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authInterceptor)
                .build()
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
    @Named("AUTHORIZATOR")
    fun provideAuthorizationInterceptor(preferences: AppPreferences): Interceptor {


        val interceptor = Interceptor { chain: Interceptor.Chain? ->
            val token = preferences.token
            Log.d("AppModule", "token = " + token)
            if (token.isNullOrEmpty()) {
                Log.d("AppModule", "handle empty")
                return@Interceptor chain!!.proceed(chain.request())
            } else {
                Log.d("AppModule", "handle nonempty")
                return@Interceptor chain!!.proceed(chain.request()
                        .newBuilder().header("Authorization", "JWT $token").build())
            }

        }
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