package com.example.proyecto.databases

import android.app.Application
import androidx.room.Room

class MyApplication:Application() {
    override fun onCreate(){
        DatabaseManager.instance.initializeDb(applicationContext)
        super.onCreate()
    }
}