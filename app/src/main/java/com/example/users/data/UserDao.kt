package com.example.users.data

import androidx.room.*
import com.example.users.mvp.models.User
import io.reactivex.Flowable

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): Flowable<List<User>>

    @Insert
    fun insertAll(users: List<User>)

    @Query("DELETE FROM user")
    fun deleteAll()

    @Transaction
    fun replaceAll(users: List<User>) {
        deleteAll()
        insertAll(users)
    }

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getById(userId: Int): Flowable<User>

}

