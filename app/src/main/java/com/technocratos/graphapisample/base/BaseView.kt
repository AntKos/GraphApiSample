package com.technocratos.graphapisample.base

interface BaseView {
    fun showError(error : String)
    fun showProgress()
    fun hideProgress()
}