package com.technocratos.graphapisample.auth.activities

import android.os.Bundle
import com.technocratos.graphapisample.R
import com.technocratos.graphapisample.auth.presenter.LoginPresenter
import com.technocratos.graphapisample.auth.view.LoginView
import com.technocratos.graphapisample.base.BaseActivity
import com.technocratos.graphapisample.extensions.moveNext
import com.technocratos.graphapisample.main.activities.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

    companion object {
        var TAG = LoginActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginActivityButtonGo.setOnClickListener {
            handleLogin(loginActivityTextUsername.text.toString(),
                    loginActivityTextPassword.text.toString())
        }
    }

    fun handleLogin(username: String, password: String) {
        presenter.handleLoginClick(username, password)
    }

    override fun handleSuccess() {
        moveNext(MainActivity::class.java)
    }
}
