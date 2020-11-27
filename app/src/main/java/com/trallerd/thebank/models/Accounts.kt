package com.trallerd.thebank.models
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
class Accounts(
        var balance: Double,
        @ForeignKey(
        entity = Users::class,
        parentColumns = ["id"],
        childColumns = ["fk_user"]
    )
    @ColumnInfo(name = "fk_user")
        var fkUser: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}