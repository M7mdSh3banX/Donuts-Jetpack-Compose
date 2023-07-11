package com.shaban.donuts.ui.screen.home


data class HomeUiState(
    val donut: DonutUiState = DonutUiState()
)

data class DonutUiState(
    val id: String = "",
    val image: Int = 0,
    val name: String = "",
    val description: String = "",
    val price: String = "",
    val sale: String = "",
    val isFavorite: Boolean = false
)
