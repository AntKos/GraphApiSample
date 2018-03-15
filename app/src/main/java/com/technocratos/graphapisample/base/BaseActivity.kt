package com.technocratos.graphapisample.base

import android.app.ProgressDialog
import android.os.Bundle
import com.technocratos.graphapisample.extensions.showToast
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity : DaggerAppCompatActivity(), BaseView {

    lateinit var progress : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progress = ProgressDialog(this)
    }

    override fun showProgress() {
        progress.setCancelable(false)
        progress.show()
    }

    override fun hideProgress() {
        progress.hide()
    }

    override fun showError(error: String) {
        showToast(error)
    }
}