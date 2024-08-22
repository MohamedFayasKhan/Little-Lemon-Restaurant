package com.mohamedfayaskhan.littlelemonrestaurant.model

sealed class Category(var value: String) {
    data object Meals: Category("Meals")
    data object Starters: Category("Starters")
    data object Lunch: Category("Lunch")
    data object Dinner: Category("Dinner")
    data object Juices: Category("Juices")
}
