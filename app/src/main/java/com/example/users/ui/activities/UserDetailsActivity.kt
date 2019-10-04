package com.example.users.ui.activities

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.users.R
import com.example.users.mvp.models.User
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity(R.layout.activity_user_details) {

    companion object{
        private const val userIdentifier = "userInstance"

        fun start(context: Context, user: User)
        {
            val intent = Intent(context, UserDetailsActivity::class.java)
            intent.putExtra(userIdentifier, Gson().toJson(user))
            context.startActivity(intent)
        }
    }

    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        user = Gson().fromJson(intent.getStringExtra(userIdentifier), User::class.java)

        with(user)
        {
            Picasso.get().load(avatar).into(avatarImageView)
            firstNameTextView.text = firstName
            lastNameTextView.text = lastName
            emailTextView.text = email
        }
    }

}
