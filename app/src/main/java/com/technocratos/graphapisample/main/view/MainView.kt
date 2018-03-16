package com.technocratos.graphapisample.main.view

import com.technocratos.data.ListUsersQuery
import com.technocratos.graphapisample.base.BaseView

interface MainView : BaseView {
    fun setUserList(list : List<ListUsersQuery.ListUser>?)
}