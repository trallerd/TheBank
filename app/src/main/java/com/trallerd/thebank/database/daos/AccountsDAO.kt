package com.trallerd.thebank.database.daos
import androidx.room.*
import com.trallerd.thebank.models.Accounts

@Dao
interface AccountsDAO {

    @Query("SELECT balance FROM Accounts WHERE fk_user LIKE :userId")
    fun getBalance(userId: Long): Double

    @Insert
    fun insert(account: Accounts): Long

    @Delete
    fun delete(account: Accounts)

    @Update
    fun update(account: Accounts)
}