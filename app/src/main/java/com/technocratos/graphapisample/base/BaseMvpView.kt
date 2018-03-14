package com.technocratos.graphapisample.base

import com.arellomobile.mvp.MvpView


interface BaseMvpView : MvpView {
    fun showError(error : String)
    fun showProgress()
    fun hideProgress()
}