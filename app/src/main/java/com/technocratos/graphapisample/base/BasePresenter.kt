package com.technocratos.graphapisample.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter <out T : BaseView> constructor( val view : T ) {

    val disposable : CompositeDisposable = CompositeDisposable()

    fun execute(action : Disposable) {
        disposable.add(action)
    }

    fun finish() = disposable.dispose()

}