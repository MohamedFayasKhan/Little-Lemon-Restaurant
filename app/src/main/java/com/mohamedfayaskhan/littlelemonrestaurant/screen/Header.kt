package com.mohamedfayaskhan.littlelemonrestaurant.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mohamedfayaskhan.littlelemonrestaurant.R
import com.mohamedfayaskhan.littlelemonrestaurant.ui.theme.primaryGreen

@Composable
fun Header(cartItems: MutableIntState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.heading
            ),
            contentDescription = null,
            modifier = Modifier.weight(0.8f)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter = painterResource(
                id = R.drawable.cart
            ),
            contentDescription = null,
            colorFilter = ColorFilter.tint(primaryGreen)
        )
        Text(
            text = "${cartItems.intValue}",
            color = primaryGreen,
            modifier = Modifier
                .offset(x = (-3).dp, y = 10.dp)
        )
    }
}