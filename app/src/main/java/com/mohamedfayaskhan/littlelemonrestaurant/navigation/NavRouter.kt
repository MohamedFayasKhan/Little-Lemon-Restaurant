package com.mohamedfayaskhan.littlelemonrestaurant.navigation

import androidx.annotation.DrawableRes
import com.mohamedfayaskhan.littlelemonrestaurant.R


sealed class NavRouter(
    val title: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unSelectedIcon: Int,
    val route: String
) {
    data object Home: NavRouter(
        title = "Home",
        selectedIcon = R.drawable.home,
        unSelectedIcon = R.drawable.outline_home,
        route = "home"
    )
    data object Food: NavRouter(
        title = "Food",
        selectedIcon = R.drawable.fastfood,
        unSelectedIcon = R.drawable.outline_fastfood,
        route = "food"
    )
    data object ViewFood: NavRouter(
        title = "ViewFood",
        selectedIcon = R.drawable.fastfood,
        unSelectedIcon = R.drawable.outline_fastfood,
        route = "view_food"
    )
}