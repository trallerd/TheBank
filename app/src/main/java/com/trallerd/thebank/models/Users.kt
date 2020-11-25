package com.trallerd.thebank.models

class Users(
    var userName: String,
    var password: String
) {
    companion object{
        fun getALL(): List<Users>{
            return listOf(
                Users("Jess","1234"),
                Users("Lola","5678"),
                Users("Bel","3256"),
                Users("Kika","1245")
            )
        }
    }
}