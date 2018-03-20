package com.technocratos.graphapisample.auth.activities

import android.os.Bundle
import com.technocratos.graphapisample.R
import com.technocratos.graphapisample.auth.presenter.SignUpPresenter
import com.technocratos.graphapisample.base.BaseActivity
import com.technocratos.graphapisample.extensions.getValue
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity<SignUpPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUpActivityButtonGo.setOnClickListener {
            presenter.doSignUp(signUpActivityTextUsername.getValue(),
                    signUpActivityTextPassword.getValue(),
                    signUpActivityEmail.getValue(),
                    signUpActivityTextFirstName.getValue(),
                    signUpActivityTextLastName.getValue(),
                    signUpActivityPhones.getValue())
        }
    }
}
