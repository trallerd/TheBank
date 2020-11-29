package com.trallerd.thebank.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.trallerd.thebank.models.Users

@Dao
interface UsersDAO {

    @Query("SELECT * FROM users WHERE username LIKE :username AND password LIKE :password")
    fun getUser(username: String, password: String): Users

    @Insert
    fun insert(user: Users): Long

    @Delete
    fun delete(user: Users)
}