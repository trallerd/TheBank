package com.trallerd.thebank.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.trallerd.thebank.database.daos.RecordsDAO
import com.trallerd.thebank.database.daos.UsersDAO
import com.trallerd.thebank.models.Records
import com.trallerd.thebank.models.Users

@Database(entities = [Users::class, Records::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UsersDAO
    abstract fun recordDAO(): RecordsDAO
}