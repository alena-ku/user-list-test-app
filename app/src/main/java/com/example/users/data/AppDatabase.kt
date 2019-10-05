package com.example.users.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.users.mvp.models.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}