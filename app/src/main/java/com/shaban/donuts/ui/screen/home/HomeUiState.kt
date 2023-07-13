package com.shaban.donuts.ui.screen.home


data class HomeUiState(
    val largeDonuts: List<DonutUiState> = emptyList(),
    val smallDonuts: List<DonutUiState> = emptyList()
)

data class DonutUiState(
    val id: Int = 0,
    val image: Int = 0,
    val name: String = "",
    val description: String = "",
    val price: Int = 0,
    val sale: Int = 0,
    val isFavorite: Boolean = false
)