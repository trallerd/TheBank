package com.trallerd.thebank.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity
class Records(
    var value: Double,
    var person: String,
    var remarks: String,
    var receive: Boolean = false,
    @ForeignKey(
        entity = Users::class,
        parentColumns = ["id"],
        childColumns = ["fk_user"]
    )
    @ColumnInfo(name = "fk_user")
    var fkUser: Long,
    var registredAt: String = SimpleDateFormat("dd/MM/yyyy HH:mm").format(Date())
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    override fun equals(other: Any?) = other is Records && this.id == other.id;
}