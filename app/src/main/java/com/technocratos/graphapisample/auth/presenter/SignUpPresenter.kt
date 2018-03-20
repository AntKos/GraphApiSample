package com.technocratos.graphapisample.auth.presenter

import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.rx2.Rx2Apollo
import com.technocratos.data.RegisterUserMutation
import com.technocratos.graphapisample.auth.view.LoginView
import com.technocratos.graphapisample.auth.view.SignUpView
import com.technocratos.graphapisample.base.AppPreferences
import com.technocratos.graphapisample.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SignUpPresenter @javax.inject.Inject constructor(view: SignUpView,
                                                       val apolloClient: ApolloClient,
                                                       val preferences: AppPreferences) : BasePresenter<LoginView>(view) {


    fun doSignUp(username: String, password: String, email: String,
                 firstName: String, lastName: String, phone: String) {
        val mutation = RegisterUserMutation(username, password, email, Input.optional(firstName),
                Input.optional(lastName), Input.optional(arrayListOf(phone)))
        execute(Rx2Apollo.from(apolloClient.mutate(mutation))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe({ view.showProgress() })
                .doOnTerminate({ view.hideProgress() })
                .doOnError({ t -> t.printStackTrace() })
                .subscribe({
                    Log.d(LoginPresenter.TAG, "response = " + it)
                    if (it.hasErrors()) {
                        view.showError(it.errors()[0].message()!!)
                    } else {
                        //TODO:find token
                        //   preferences.token = it.data()?.registerUser()?.user()?.t ?: ""
                        preferences.userId = it.data()?.registerUser()?.user()?.id() ?: ""
                        Log.d(LoginPresenter.TAG, "setToken, check: = " + preferences.token)

                        view.handleSuccess()
                    }
                }))
    }
}