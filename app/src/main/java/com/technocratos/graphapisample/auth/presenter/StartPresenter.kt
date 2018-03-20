package com.technocratos.graphapisample.auth.presenter

import com.technocratos.graphapisample.auth.view.StartView
import com.technocratos.graphapisample.base.BasePresenter
import javax.inject.Inject

class StartPresenter @Inject constructor(view : StartView): BasePresenter<StartView>(view) {
}