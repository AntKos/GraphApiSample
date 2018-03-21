package com.technocratos.graphapisample.extensions

import android.widget.EditText

fun EditText.getValue() : String {
    return this.text.toString()
}