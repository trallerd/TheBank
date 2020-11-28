package com.trallerd.thebank.database.daos
import androidx.room.*
import com.trallerd.thebank.models.Records

@Dao
interface RecordsDAO {

    @Query("SELECT * FROM records WHERE fk_user LIKE :id")
    fun getAllById(id: Long): List<Records>

    @Query("SELECT * FROM records WHERE (fk_user=:id) AND (id=:idRec)")
    fun getRecordById(id: Long, idRec: Long): Records

    @Query("SELECT * FROM records")
    fun getAll(): List<Records>

    @Query("SELECT * FROM records WHERE person=:name")
    fun getAllByName(name: String): List<Records>

    @Query("SELECT SUM(value) FROM records WHERE (fk_user=:id) AND (receive=:boolean)")
    fun getWallet(id: Long, boolean: Int): Double

    @Insert
    fun insert(record: Records): Long

    @Delete
    fun delete(record: Records)

    @Update
    fun update(record: Records)
}