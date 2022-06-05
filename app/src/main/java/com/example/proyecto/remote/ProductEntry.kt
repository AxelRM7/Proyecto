package com.example.proyecto.remote

import com.google.gson.annotations.SerializedName

data class ProductEntry (
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("rating")
    val rating: CalificacionEntry,
    @SerializedName("image")
    val image: String,

    )

    /*"id": 1,
    "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
    "price": 109.95,
    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
    "category": "men's clothing",
    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
    "rating": {
    "rate": 3.9,
    "count": 120*/

data class CalificacionEntry(
    @SerializedName("rate")
    val rated: Float,
    @SerializedName("count")
    val count: Int
)

