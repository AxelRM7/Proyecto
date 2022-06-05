package com.example.proyecto.databases

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductoDao {

    @Query("SELECT * FROM Producto")
    suspend fun getAll(): List<Producto>

    /*@Query("SELECT * FROM Producto WHERE idUs = idUs")
    suspend fun getbyIdUs(idUs: Int): Producto*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(producto: Producto)

    @Delete
    fun delete(producto: Producto)
}