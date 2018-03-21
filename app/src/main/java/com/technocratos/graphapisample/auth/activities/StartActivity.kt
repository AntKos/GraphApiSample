package com.technocratos.graphapisample.auth.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.technocratos.graphapisample.R
import com.technocratos.graphapisample.auth.presenter.StartPresenter
import com.technocratos.graphapisample.auth.view.StartView
import com.technocratos.graphapisample.main.activities.MainActivity
import com.technocratos.graphapisample.base.AppPreferences
import com.technocratos.graphapisample.base.BaseActivity
import com.technocratos.graphapisample.extensions.moveNext
import kotlinx.android.synthetic.main.activity_start.*
import javax.inject.Inject

class StartActivity : BaseActivity<StartPresenter>(), StartView {
    companion object {
        var TAG = "StartActivity"
    }

    @Inject
    lateinit var preferences: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "token = " + preferences.token)

        if (preferences.token.isNullOrEmpty()) {
            setupActivity()
        } else {
            moveNext(MainActivity::class.java)
        }
    }

    fun setupActivity() {
        setContentView(R.layout.activity_start)
        startActivityButtonLogin.setOnClickListener { moveNext(LoginActivity::class.java) }
        startActivityButtonSignUp.setOnClickListener { moveNext(SignUpActivity::class.java) }
    }
}
