package com.shaban.donuts.ui.screen.donutDetails

data class DonutUiState(
    val id: Int = 0,
    val image: Int = 0,
    val name: String = "",
    val description: String = "",
    val isFavorite: Boolean = false,
    val quantity: Int = 0,
    val price: Double = 0.0
)