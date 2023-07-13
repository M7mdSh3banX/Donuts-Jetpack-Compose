package com.shaban.donuts.data

import com.shaban.donuts.R
import com.shaban.donuts.ui.screen.home.DonutUiState

val StrawberryWheel = DonutUiState(
    id = 1,
    name = "Strawberry Wheel",
    image = R.drawable.strawberry_wheel_donut,
    description = "These Baked Strawberry Donuts are filled with fresh strawberries",
    price = 16,
    sale = 20,
    isFavorite = false
)

val ChocolateGlaze = DonutUiState(
    id = 2,
    name = "Chocolate Glaze",
    image = R.drawable.chocolate_glaze_donut,
    description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
    price = 29,
    sale = 20,
    isFavorite = false
)

val PinkDonut = DonutUiState(
    id = 3,
    name = "Pink Donut",
    image = R.drawable.pink_donut,
    description = "These Baked Strawberry Donuts are filled with fresh strawberries",
    price = 32,
    sale = 25,
    isFavorite = false
)

val CoffeeDonut = DonutUiState(
    id = 4,
    name = "Coffee Donut",
    image = R.drawable.coffee_donut,
    description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
    price = 19,
    sale = 15,
    isFavorite = false
)

val ChocolateCherry = DonutUiState(
    id = 5,
    name = "Chocolate Cherry",
    image = R.drawable.chocolate_cherry_donut,
    description = "These Baked Strawberry Donuts are filled with fresh strawberries",
    price = 12,
    sale = 9,
    isFavorite = false,
)

val StrawberryRain = DonutUiState(
    id = 6,
    name = "Strawberry Rain",
    image = R.drawable.strawberry_rain_donut,
    description = "These Baked Strawberry Donuts are filled with fresh strawberries",
    price = 5,
    sale = 3,
    isFavorite = false,
)

val StrawberryCoco = DonutUiState(
    id = 7,
    name = "Strawberry Coco",
    image = R.drawable.strawberry_coco_donut,
    description = "These Baked Strawberry Donuts are filled with fresh strawberries",
    price = 8,
    sale = 5,
    isFavorite = false,
)

val largeDonuts =
    listOf(
        StrawberryWheel,
        ChocolateGlaze,
        PinkDonut,
        CoffeeDonut,
    )
val smallDonuts = listOf(
    ChocolateCherry,
    StrawberryRain,
    StrawberryCoco
)