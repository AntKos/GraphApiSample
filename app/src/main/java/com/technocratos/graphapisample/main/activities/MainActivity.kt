package com.technocratos.graphapisample.main.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.technocratos.data.ListUsersQuery
import com.technocratos.graphapisample.R
import com.technocratos.graphapisample.base.BaseActivity
import com.technocratos.graphapisample.main.adapter.UserListAdapter
import com.technocratos.graphapisample.main.presenter.MainPresenter
import com.technocratos.graphapisample.main.view.MainView
import com.technocratos.graphapisample.view.SpacingItemDecorator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>() , MainView {
    lateinit var adapter : UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()
        presenter.fetch()
    }

    override fun setUserList(list: List<ListUsersQuery.ListUser>) {
        Log.d("MainActivity", "setUserList $list, size = ${list.size} ")
        adapter.data = list
    }

    fun initList() {
        adapter = UserListAdapter(this)
        mainActivityRecycler.addItemDecoration(SpacingItemDecorator(resources.getDimension(R.dimen.spacing_1).toInt()))
        mainActivityRecycler.layoutManager = LinearLayoutManager(this)
        mainActivityRecycler.adapter = adapter
    }
}
