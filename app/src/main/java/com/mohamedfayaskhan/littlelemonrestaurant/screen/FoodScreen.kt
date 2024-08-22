package com.mohamedfayaskhan.littlelemonrestaurant.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mohamedfayaskhan.littlelemonrestaurant.model.Constant
import com.mohamedfayaskhan.littlelemonrestaurant.navigation.NavRouter

@Composable
fun FoodScreen(cartItems: MutableIntState, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Header(cartItems = cartItems)
        }
        items(Constant.dishes.value) { item ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(NavRouter.ViewFood.route + "/${item.id}")
                    }
            ) {
                Text(text = "Name: ${item.name}", modifier = Modifier.padding(16.dp))
                Text(text = "Category: ${item.category.value}", modifier = Modifier.padding(16.dp))
                Text(text = "Price: ${item.price}", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
            }
        }
    }
}