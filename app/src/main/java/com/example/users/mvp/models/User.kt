package com.example.users.mvp.models

import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class User (

    @Expose
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Int,

    @Expose
    @SerializedName("first_name")
    @ColumnInfo(name = "first_name")
    var firstName: String,

    @Expose
    @SerializedName("last_name")
    @ColumnInfo(name = "last_name")
    var lastName: String,

    @Expose
    @SerializedName("email")
    @ColumnInfo(name = "email")
    var email: String,

    @Expose
    @SerializedName("avatar")
    @ColumnInfo(name = "avatar")
    var avatar: String

)

