package com.trallerd.thebank.models

import java.text.SimpleDateFormat
import java.util.*

class Records(
    var value: Double,
    var person: String,
    var remarks: String,
    var registredAt: Date = Date()

) {

    companion object{
        fun getALL(): List<Records> {
            return listOf(
                Records(19.20,"Jess","chocolate"  ),
                Records(19.20,"Jess","pasta"),
                Records(19.20,"Jess","mesada"),
                Records(19.20,"Jess","agua")
            )
        }
    }
}