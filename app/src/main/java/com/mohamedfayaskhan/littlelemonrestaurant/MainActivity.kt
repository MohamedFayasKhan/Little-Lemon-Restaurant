package com.mohamedfayaskhan.littlelemonrestaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mohamedfayaskhan.littlelemonrestaurant.navigation.BottomBar
import com.mohamedfayaskhan.littlelemonrestaurant.navigation.BottomNavGraph
import com.mohamedfayaskhan.littlelemonrestaurant.navigation.NavRouter
import com.mohamedfayaskhan.littlelemonrestaurant.ui.theme.LittleLemonRestaurantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            val backstackState = navHostController.currentBackStackEntryAsState().value

            val isBottomBarVisible = remember(key1 = backstackState) {
                backstackState?.destination?.route == NavRouter.Home.route ||
                        backstackState?.destination?.route == NavRouter.Food.route
            }
            LittleLemonRestaurantTheme {
                Scaffold(
                    bottomBar = {
                        if (isBottomBarVisible) {
                            BottomBar(navHostController = navHostController)
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        BottomNavGraph(navController = navHostController)
                    }
                }
            }
        }
    }
}