package com.technocratos.graphapisample.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.technocratos.data.ListUsersQuery
import com.technocratos.graphapisample.R

class UserListAdapter : RecyclerView.Adapter<UserListViewHolder>() {

    var data: List<ListUsersQuery.ListUser>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.setData(data!![position])
    }

    override fun getItemCount(): Int {
        return data?.count() ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_user, parent, false))
    }
}