package com.mohamedfayaskhan.littlelemonrestaurant.model

data class Dish(
    val id: Int,
    val name: String,
    val price: Double,
    val category: Category
)
