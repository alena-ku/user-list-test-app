package com.example.users.mvp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("first_name")
    @Expose
    lateinit var firstName: String

    @SerializedName("last_name")
    @Expose
    lateinit var lastName: String

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

}

