package com.technocratos.graphapisample.auth.activities

import android.os.Bundle
import com.technocratos.graphapisample.R
import com.technocratos.graphapisample.auth.presenter.LoginPresenter
import com.technocratos.graphapisample.auth.view.LoginView
import com.technocratos.graphapisample.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginView {

    companion object {
        var TAG = LoginActivity::class.java.simpleName
    }

    @Inject
    lateinit var presenter : LoginPresenter

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

}
