package com.technocratos.graphapisample.auth.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.technocratos.graphapisample.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        startActivityButtonLogin.setOnClickListener { moveNext(LoginActivity::class.java) }
    }

    fun <T : Activity> moveNext(activityClass : Class<T>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }

}
