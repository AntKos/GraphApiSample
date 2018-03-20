package com.technocratos.graphapisample.base

import android.app.ProgressDialog
import android.os.Bundle
import com.technocratos.graphapisample.extensions.showToast
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

open class BaseActivity<T : BasePresenter<BaseView>> : DaggerAppCompatActivity(), BaseView {

    lateinit var progress : ProgressDialog

    @Inject
    lateinit var presenter : T

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

    override fun onDestroy() {
        presenter.finish()
        super.onDestroy()
    }
}