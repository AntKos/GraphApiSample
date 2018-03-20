package com.technocratos.graphapisample.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.technocratos.data.ListUsersQuery
import kotlinx.android.synthetic.main.item_view_user.view.*

class UserListViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    fun setData(data : ListUsersQuery.ListUser) {
        itemView.itemViewUserFirstName.text = data.firstName()
        itemView.itemViewUserLastName.text = data.lastName()
        itemView.itemViewUserUserName.text = data.username()
    }

}