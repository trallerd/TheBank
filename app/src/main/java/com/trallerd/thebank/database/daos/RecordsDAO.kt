package com.trallerd.thebank.database.daos
import androidx.room.*
import com.trallerd.thebank.models.Records

@Dao
interface RecordsDAO {

    @Query("SELECT * FROM records WHERE fk_user LIKE :id")
    fun getAllById(id: Long): List<Records>

    @Query("SELECT SUM(value) FROM records WHERE fk_user LIKE :id AND receive=='false'")
    fun getIncomes(id: Long): Double

    @Query("SELECT SUM(value) FROM records WHERE fk_user LIKE :id AND receive=='true'")
    fun getSpent(id: Long): Double

    @Insert
    fun insert(record: Records): Long

    @Delete
    fun delete(record: Records)

    @Update
    fun update(record: Records)
}