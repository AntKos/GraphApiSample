package com.technocratos.graphapisample.main.presenter

import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import com.technocratos.data.ListUsersQuery
import com.technocratos.graphapisample.auth.presenter.LoginPresenter
import com.technocratos.graphapisample.base.BasePresenter
import com.technocratos.graphapisample.main.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(view: MainView, val apolloClient: ApolloClient) : BasePresenter<MainView>(view) {

    fun fetch() {
        val query = ListUsersQuery()
        execute(Rx2Apollo.from(apolloClient.query(query))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe({ view.showProgress() })
                .doOnTerminate({ view.hideProgress() })
                .doOnError({ t -> t.printStackTrace() })
                .subscribe {
                    Log.d(LoginPresenter.TAG, "response = " + it)
                    if (it.hasErrors()) {
                        view.showError(it.errors()[0].message()!!)
                    } else {
                        view.setUserList(it.data()?.listUsers() ?: ArrayList())
                    } }
        )
    }
}