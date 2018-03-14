package com.technocratos.graphapisample.auth.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import com.arellomobile.mvp.presenter.InjectPresenter
import com.technocratos.data.LoginUserQuery
import com.technocratos.graphapisample.R
import com.technocratos.graphapisample.auth.presenter.LoginPresenter
import com.technocratos.graphapisample.auth.view.LoginView
import com.technocratos.graphapisample.base.AppPreferences
import com.technocratos.graphapisample.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginView {

    var TAG = LoginActivity::class.java.simpleName

    @Inject
    lateinit var apolloClient: ApolloClient
    @Inject
    lateinit var preferences: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginActivityButtonGo.setOnClickListener {
            handleLogin(loginActivityTextUsername.text.toString(),
                    loginActivityTextPassword.text.toString())
        }
    }

    fun handleLogin(username: String, password: String) {
        val query = LoginUserQuery(username, password)
        Rx2Apollo.from(apolloClient.query(query))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe({ showProgress() })
                .doOnTerminate({ hideProgress() })
                .doOnError({ t -> t.printStackTrace() })
                .subscribe({ response ->
                    Log.d(TAG, "response = " + response)
                    if (response.hasErrors()) {
                        showError(response.errors()[0].message()!!)
                    } else {
                        preferences.token = response.data()?.loginUser()?.token() ?: ""
                        preferences.userId = response.data()?.loginUser()?.user()?.id() ?: ""
                    }
                })
    }

}
