package com.example.proyecto.databases

import android.content.Context
import androidx.room.Room

class DatabaseManager {
    lateinit var database: AppDataBase

    fun  initializeDb(context: Context){
        createDb(context)
    }
    private fun  createDb(context: Context){
        val room= Room.databaseBuilder(context,AppDataBase::class.java, "producto")
            .build()
    }

    companion object{
        val instance = DatabaseManager()
    }
}