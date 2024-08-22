package com.mohamedfayaskhan.littlelemonrestaurant.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mohamedfayaskhan.littlelemonrestaurant.R
import com.mohamedfayaskhan.littlelemonrestaurant.model.Constant

@Composable
fun ViewFood(id: String, cartItems: MutableIntState) {
    val food = Constant.dishes.value.filter { it.id == id.toInt() }[0]
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(cartItems = cartItems)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "Name :")
            Text(text = food.name)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Price :")
            Text(text = food.price.toString())
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Category :")
            Text(text = food.category.value)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { cartItems.intValue++ }) {
                Icon(painter = painterResource(id = R.drawable.remove), contentDescription = null)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "${cartItems.intValue}")
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = { cartItems.intValue++ }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }
        }
    }
}