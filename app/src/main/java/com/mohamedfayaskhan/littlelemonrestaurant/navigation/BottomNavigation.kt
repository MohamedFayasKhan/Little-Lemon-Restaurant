package com.mohamedfayaskhan.littlelemonrestaurant.navigation

import android.util.Log
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.mohamedfayaskhan.littlelemonrestaurant.screen.FoodScreen
import com.mohamedfayaskhan.littlelemonrestaurant.screen.HomeScreen
import com.mohamedfayaskhan.littlelemonrestaurant.screen.ViewFood
import com.mohamedfayaskhan.littlelemonrestaurant.ui.theme.lightHighlight
import com.mohamedfayaskhan.littlelemonrestaurant.ui.theme.primaryGreen
import com.mohamedfayaskhan.littlelemonrestaurant.ui.theme.primaryYellow

@Composable
fun BottomBar(navHostController: NavHostController) {
    val navItems = listOf(
        NavRouter.Home,
        NavRouter.Food
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar(
        containerColor = primaryGreen,
        contentColor = primaryYellow,
        tonalElevation = 10.dp
    ) {
        navItems.forEach { navItem ->
            val selected = currentDestination?.hierarchy?.any {
                it.route == navItem.route
            }
            if (selected != null) {
                NavigationBarItem(
                    colors = androidx.compose.material3.NavigationBarItemDefaults
                        .colors(
                            selectedIconColor = primaryYellow,
                            indicatorColor = lightHighlight
                        ),
                    selected = selected,
                    onClick = {
                        if (currentDestination.route != navItem.route) {
                            navHostController.navigate(navItem.route) {
                                popUpTo(navHostController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        } else {
                            Log.d("Navigation", "BottomBar: already at ${navItem.route}")
                        }
                    },
                    icon = {
//                        BadgedBox(badge = { null }) {
                        Icon(
                            painter = if (selected) {
                                painterResource(id = navItem.selectedIcon)
                            } else {
                                painterResource(id = navItem.unSelectedIcon)
                            },
                            contentDescription = navItem.title,
                            tint = primaryYellow
                        )
//                        }
                    },
                    alwaysShowLabel = true,
                    label = {
                        Text(
                            text = navItem.title,
                            color = primaryYellow
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    val cartItems = rememberSaveable {
        mutableIntStateOf(0)
    }
    NavHost(navController = navController, startDestination = NavRouter.Home.route) {
        composable(
            route = NavRouter.Home.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            HomeScreen(cartItems, navController)
        }
        composable(
            route = NavRouter.Food.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            FoodScreen(cartItems, navController)
        }
        composable(
            route = NavRouter.ViewFood.route + "/{id}",
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() },
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            ViewFood(id = entry.arguments?.getString("id")!!, cartItems)
        }
    }
}