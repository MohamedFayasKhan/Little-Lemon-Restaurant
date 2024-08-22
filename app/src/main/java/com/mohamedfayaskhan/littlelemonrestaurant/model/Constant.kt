package com.mohamedfayaskhan.littlelemonrestaurant.model

sealed class Constant(val value: List<Dish>) {
    data object dishes: Constant(
        listOf(
            Dish(
                id = 1,
                name = "Crock pot pulled pork",
                price = 20.0,
                category = Category.Meals
            ),
            Dish(
                id = 2,
                name = "Lasagna",
                price = 12.0,
                category = Category.Meals
            ),
            Dish(
                id = 3,
                name = "Baked salmon",
                price = 12.89,
                category = Category.Meals
            ),
            Dish(
                id = 4,
                name = "Roast chicken",
                price = 34.77,
                category = Category.Meals
            ),
            Dish(
                id = 5,
                name = "Vegetable soup",
                price = 14.56,
                category = Category.Meals
            ),
            Dish(
                id = 6,
                name = "Sheet pan fajitas",
                price = 16.99,
                category = Category.Meals
            ),
            Dish(
                id = 7,
                name = "Amla Juice",
                price = 10.45,
                category = Category.Juices
            ),
            Dish(
                id = 8,
                name = "Orange Juice",
                price = 13.45,
                category = Category.Juices
            ),
            Dish(
                id = 9,
                name = "Pomegranate Juice",
                price = 17.59,
                category = Category.Juices
            ),
            Dish(
                id = 10,
                name = "Pineapple Juice",
                price = 13.15,
                category = Category.Juices
            ),
            Dish(
                id = 11,
                name = "Cranberry Juice",
                price = 20.15,
                category = Category.Juices
            ),
            Dish(
                id = 12,
                name = "Apple Juice",
                price = 16.45,
                category = Category.Juices
            ),
            Dish(
                id = 13,
                name = "Air-fryer salmon",
                price = 26.45,
                category = Category.Dinner
            ),
            Dish(
                id = 14,
                name = "Sweet potato & peanut curry",
                price = 12.75,
                category = Category.Dinner
            ),
            Dish(
                id = 15,
                name = "Beef stroganoff",
                price = 18.45,
                category = Category.Dinner
            ),
            Dish(
                id = 16,
                name = "Chicken & chorizo jambalaya",
                price = 15.45,
                category = Category.Dinner
            ),
            Dish(
                id = 17,
                name = "Lasagne",
                price = 26.45,
                category = Category.Dinner
            ),
            Dish(
                id = 18,
                name = "No-fuss shepherd's pie",
                price = 21.45,
                category = Category.Dinner
            ),
            Dish(
                id = 19,
                name = "Soup",
                price = 9.75,
                category = Category.Lunch
            ),
            Dish(
                id = 20,
                name = "Rice paper rolls",
                price = 19.89,
                category = Category.Lunch
            ),
            Dish(
                id = 21,
                name = "Salads",
                price = 12.45,
                category = Category.Lunch
            ),
            Dish(
                id = 22,
                name = "Noodles with veggies and herbs",
                price = 14.45,
                category = Category.Lunch
            ),
            Dish(
                id = 23,
                name = "Frittatas",
                price = 17.45,
                category = Category.Lunch
            ),
            Dish(
                id = 24,
                name = "Sushi rolls",
                price = 21.45,
                category = Category.Lunch
            ),
            Dish(
                id = 25,
                name = "Paneer tikka",
                price = 27.45,
                category = Category.Starters
            ),
            Dish(
                id = 26,
                name = "Medu vada",
                price = 11.45,
                category = Category.Starters
            ),
            Dish(
                id = 27,
                name = "Dahi Kebabs",
                price = 13.45,
                category = Category.Starters
            ),
            Dish(
                id = 28,
                name = "Gobi manchurian",
                price = 18.45,
                category = Category.Starters
            ),
            Dish(
                id = 29,
                name = "Bruschetta",
                price = 15.45,
                category = Category.Starters
            ),
            Dish(
                id = 30,
                name = "Aloo Tikki Chaat",
                price = 16.45,
                category = Category.Starters
            )
        )
    )
}