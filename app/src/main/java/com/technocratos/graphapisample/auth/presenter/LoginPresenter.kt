package com.technocratos.graphapisample.auth.presenter

import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.technocratos.data.LoginUserQuery
import com.technocratos.graphapisample.app.App
import com.technocratos.graphapisample.auth.view.LoginView
import com.technocratos.graphapisample.base.AppPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class LoginPresenter @Inject constructor(val apolloClient: ApolloClient, val preferences: AppPreferences) : MvpPresenter<LoginView>() {
    companion object {
        val TAG: String = LoginPresenter.javaClass.simpleName
    }

    fun handleLoginClick(login: String, password: String) {
        val query: LoginUserQuery = LoginUserQuery(login, password)
        Rx2Apollo.from(apolloClient.query(query))
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe({ viewState.showProgress() })
                .doOnTerminate({ viewState.hideProgress() })
                .doOnError({ t -> t.printStackTrace() })
                .subscribe({ response ->
                    Log.d(TAG, "response = " + response)
                    preferences.token = response.data()?.loginUser()?.token() ?: ""
                    preferences.userId = response.data()?.loginUser()?.user()?.id() ?: ""
                })
    }



}