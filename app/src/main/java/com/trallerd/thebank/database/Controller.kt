package com.trallerd.thebank.database

import android.app.Application
import com.trallerd.thebank.models.Users

class Controller: Application() {
    companion object{
        var users: Users? = null
    }

}