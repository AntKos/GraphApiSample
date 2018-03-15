package com.technocratos.graphapisample.base

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class AppPreferences(context: Context) {
    private val FILENAME: String = "preferences"
    private val prefs: SharedPreferences = context.getSharedPreferences(FILENAME, MODE_PRIVATE)

    private val KEY_TOKEN: String = "token"
    private val KEY_USERID: String = "user_id"

    var token: String
        get() = prefs.getString(KEY_TOKEN, null)
        set(value) = prefs.edit().putString(KEY_TOKEN, value).apply()

    var userId: String
        get() = prefs.getString(KEY_USERID, null)
        set(value) = prefs.edit().putString(KEY_USERID, value).apply()

}
