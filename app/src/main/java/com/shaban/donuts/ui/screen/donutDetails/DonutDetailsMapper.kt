package com.shaban.donuts.ui.screen.donutDetails

import com.shaban.donuts.ui.screen.home.DonutUiState

fun List<DonutUiState>.toDonutDetailsUiState(): List<DonutDetailsUiState> {
    return this.map {
        DonutDetailsUiState(
            id = it.id,
            image = it.image,
            name = it.name,
            description = it.description,
            isFavorite = it.isFavorite,
            price = it.price.toDouble()
        )
    }
}