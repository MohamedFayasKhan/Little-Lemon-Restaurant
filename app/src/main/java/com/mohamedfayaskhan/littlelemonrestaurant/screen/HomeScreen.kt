package com.mohamedfayaskhan.littlelemonrestaurant.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mohamedfayaskhan.littlelemonrestaurant.R
import com.mohamedfayaskhan.littlelemonrestaurant.model.Category
import com.mohamedfayaskhan.littlelemonrestaurant.model.Constant
import com.mohamedfayaskhan.littlelemonrestaurant.navigation.NavRouter
import com.mohamedfayaskhan.littlelemonrestaurant.ui.theme.darkHighlight
import com.mohamedfayaskhan.littlelemonrestaurant.ui.theme.primaryGreen
import com.mohamedfayaskhan.littlelemonrestaurant.ui.theme.primaryYellow

@Composable
fun HomeScreen(cartItems: MutableIntState, navController: NavHostController) {
    val context = LocalContext.current
    var selectedChip by rememberSaveable {
        mutableStateOf(Category.Starters.value)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        Header(cartItems)
        Text(
            text = stringResource(R.string.chicago),
            color = primaryGreen,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 70.dp)
                .offset(y = (-30).dp)
        )
        Text(
            text = stringResource(R.string.description),
            color = primaryGreen,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(horizontal = 50.dp)
        )
        Button(
            onClick = {
                Toast.makeText(context, "Reserve a table", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End),
            colors = ButtonColors(
                containerColor = primaryYellow,
                contentColor = primaryGreen,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Black
            )
        ) {
            Text(text = stringResource(R.string.reserve_a_table))
        }
        HorizontalDivider()
        Text(
            text = "Categorize",
            color = primaryGreen,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow {
            itemsIndexed(
                listOf(
                    Category.Starters,
                    Category.Juices,
                    Category.Meals,
                    Category.Lunch,
                    Category.Dinner
                )
            ) { index, item ->
                Button(
                    colors = ButtonColors(
                        containerColor = if (selectedChip == item.value) primaryGreen else darkHighlight,
                        contentColor = Color.White,
                        disabledContentColor = Color.White,
                        disabledContainerColor = Color.Black
                    ),
                    modifier = Modifier
                        .padding(horizontal = 5.dp),
                    onClick = {
                        selectedChip = item.value
                    }
                ) {
                    Text(text = item.value)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()
        LazyColumn(
            modifier = Modifier
                .heightIn(max = 500.dp)
        ) {
            items(Constant.dishes.value.filter { it.category.value == selectedChip }) { item ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(NavRouter.ViewFood.route + "/${item.id}")
                        }
                ) {
                    Text(text = item.name, modifier = Modifier.padding(16.dp))
                    Text(text = item.price.toString(), modifier = Modifier.padding(16.dp))
                    HorizontalDivider()
                }
            }
        }
    }
}