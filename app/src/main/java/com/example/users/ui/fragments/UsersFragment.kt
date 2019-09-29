package com.example.users.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.users.R
import com.example.users.mvp.models.User
import com.example.users.mvp.presenters.UsersPresenter
import com.example.users.mvp.views.UsersView
import com.example.users.ui.activities.UserDetailsActivity
import com.example.users.ui.adapters.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView,
    UsersAdapter.Interaction {

    @InjectPresenter
    lateinit var presenter: UsersPresenter

    @ProvidePresenter
    fun providePresenter(): UsersPresenter = UsersPresenter()

    var usersRecyclerView: RecyclerView? = null

    override fun openUserDetails(userId: Int) {
        startActivity(Intent(activity, UserDetailsActivity::class.java))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usersRecyclerView = view.findViewById<RecyclerView>(R.id.usersRecyclerView)
        usersRecyclerView?.adapter = UsersAdapter(this)
    }

    override fun updateUsers(userNames: List<User>) {
        (usersRecyclerView?.adapter as UsersAdapter).submitList(userNames)
    }

    override fun userClicked(user: User) {
        presenter.onUserClick(user)
    }
}