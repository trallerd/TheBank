package com.trallerd.thebank.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Users(
    var username: String,
    var password: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    override fun equals(other: Any?) = other is Users && this.id == other.id;
}