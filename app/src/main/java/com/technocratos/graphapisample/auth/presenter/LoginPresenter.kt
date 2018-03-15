package com.technocratos.graphapisample.auth.presenter

import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import com.technocratos.data.LoginUserQuery
import com.technocratos.graphapisample.auth.view.LoginView
import com.technocratos.graphapisample.base.AppPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginPresenter @Inject constructor(val view: LoginView, val apolloClient: ApolloClient, val preferences: AppPreferences) {
    companion object {
        val TAG: String = LoginPresenter::class.java.simpleName
    }

    init {
        Log.d(TAG, "init presenter, apolloClient = $apolloClient, preferences = $preferences")
    }

    fun handleLoginClick(login: String, password: String) {
        val query = LoginUserQuery(login, password)
        Rx2Apollo.from(apolloClient.query(query))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe({ view.showProgress() })
                .doOnTerminate({ view.hideProgress() })
                .doOnError({ t -> t.printStackTrace() })
                .subscribe({ response ->
                    Log.d(TAG, "response = " + response)
                    if (response.hasErrors()) {
                        view.showError(response.errors()[0].message()!!)
                    } else {
                        preferences.token = response.data()?.loginUser()?.token() ?: ""
                        preferences.userId = response.data()?.loginUser()?.user()?.id() ?: ""
                    }
                })
    }

}