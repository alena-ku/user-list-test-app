package com.example.users.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.users.R
import com.example.users.mvp.models.User
import com.example.users.mvp.presenters.UsersPresenter
import com.example.users.mvp.views.UsersView
import com.example.users.ui.activities.UserDetailsActivity
import com.example.users.ui.adapters.UsersAdapter
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView,
    UsersAdapter.Interaction {

    private lateinit var usersAdapter: UsersAdapter
    private var errorDialog: AlertDialog? = null

    @InjectPresenter
    lateinit var presenter: UsersPresenter

    @ProvidePresenter
    fun providePresenter(): UsersPresenter = UsersPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usersRecyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        usersAdapter = UsersAdapter(this)
        usersRecyclerView.adapter = usersAdapter
    }

    override fun toggleLoading(loading: Boolean) {
        progressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }

    override fun updateUsers(userNames: List<User>) {
        usersAdapter.submitList(userNames)
    }

    override fun loadingFailed(message: String) {
        errorDialog = AlertDialog.Builder(context)
            .setTitle(R.string.app_name)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }

    override fun openUserDetails(user: User) {
        UserDetailsActivity.start(context!!, user)
    }

    override fun userClicked(user: User) {
        presenter.onUserClick(user)
    }
}