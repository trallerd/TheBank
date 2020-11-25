package com.trallerd.thebank.models

import java.time.LocalDateTime


class Records(
    var value: Double,
    var person: String,
    var remarks: String
   // var registredAt: LocalDateTime
) {

    companion object{
        fun getALL(): List<Records>{
            return listOf(
                Records(19.20,"Jess","chocolate"),
                Records(19.20,"Jess","pasta"),
                Records(19.20,"Jess","mesada"),
                Records(19.20,"Jess","agua")
            )
        }
    }
}