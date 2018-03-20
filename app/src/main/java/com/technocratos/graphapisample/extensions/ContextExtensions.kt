package com.technocratos.graphapisample.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun <T : Activity> Context.moveNext(activityClass: Class<T>) {
    val intent = Intent(this, activityClass)
    startActivity(intent)
}