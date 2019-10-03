package com.example.users.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.users.R
import com.example.users.mvp.models.User

import kotlinx.android.synthetic.main.list_item_user.view.*

class UsersAdapter(private val interaction: Interaction? = null) : ListAdapter<User, UsersAdapter.ViewHolder>(UserDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_user, parent, false))

    inner class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val clicked = getItem(adapterPosition)
            interaction?.userClicked(clicked)
        }

        fun bind(item: User) = with(itemView) {
            userTitleTextView.text = "${item.firstName} ${item.lastName}"
        }
    }

    interface Interaction {
        fun userClicked(user: User)
    }

    private class UserDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User)
                = oldItem == newItem

        override fun areContentsTheSame(oldItem: User, newItem: User)
                = oldItem.id == newItem.id
    }
}