package com.example.proyecto.databases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Producto(
    @PrimaryKey val id: Int,
    val idUs: Int,
    val name: String,
    val description: String,
    val price: String,
    val rated: String
)
