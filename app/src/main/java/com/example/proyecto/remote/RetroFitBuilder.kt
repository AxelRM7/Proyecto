package com.example.proyecto.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetroFitBuilder {

    @GET("products/{id}")
    fun getProductsById(@Path("id") id: String): Call<ProductEntry>

    companion object{
        private val BASE_URL="https://fakestoreapi.com/"

        fun create() : RetroFitBuilder{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetroFitBuilder::class.java)
        }
    }
}