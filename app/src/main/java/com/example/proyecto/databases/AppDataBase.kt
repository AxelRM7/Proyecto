package com.example.proyecto.databases

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Producto::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun productoDao():ProductoDao

}