package com.example.users.ui.activities

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import com.example.users.R
import com.example.users.mvp.models.User
import com.example.users.mvp.presenters.UserDetailsPresenter
import com.example.users.mvp.views.UserDetailsView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_details.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class UserDetailsActivity : MvpAppCompatActivity(R.layout.activity_user_details),
    UserDetailsView {

    companion object{
        private const val ARGS_USER_ID = "argsUserId"

        fun start(context: Context, user: User)
        {
            val intent = Intent(context, UserDetailsActivity::class.java)
            intent.putExtra(ARGS_USER_ID, user.id)
            context.startActivity(intent)
        }
    }

    @InjectPresenter
    lateinit var presenter: UserDetailsPresenter

    @ProvidePresenter
    fun providePresenter(): UserDetailsPresenter
            = UserDetailsPresenter(intent.getIntExtra(ARGS_USER_ID, 0))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun updateUserDetails(user: User) {
        with(user)
        {
            firstNameTextView.text = firstName
            lastNameTextView.text = lastName
            emailTextView.text = email
            Picasso.get().load(avatar).into(avatarImageView)
        }
    }

}
