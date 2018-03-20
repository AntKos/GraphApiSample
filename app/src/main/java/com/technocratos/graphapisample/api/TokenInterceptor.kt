package com.technocratos.graphapisample.api

import android.util.Log
import com.technocratos.graphapisample.base.AppPreferences
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(val preferences: AppPreferences) : Interceptor {

    companion object {
        val TAG : String = "TokenInterceptor"
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
        val token = preferences.token
        Log.d(TAG, "token = " + token)
        val builder = chain!!.request().newBuilder()
        return if (token.isNullOrEmpty()) {
            Log.d(TAG, "handle empty")
            chain.proceed(chain.request())
        } else {
            Log.d(TAG, "handle nonempty")
            val request = builder.header("Authorization", "JWT $token").build()

            chain.proceed(request)
        }
    }
}