package com.shaban.donuts.ui.screen.home

import androidx.lifecycle.ViewModel
import com.shaban.donuts.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getDonutItemDetail()
    }

    private fun getDonutItemDetail() {
        _state.update {
            it.copy(
                donut = listOf(
                    DonutUiState(
                        id = 1,
                        name = "Strawberry Wheel",
                        image = R.drawable.strawberry_wheel_donut,
                        description = "These Baked Strawberry Donuts are filled with fresh strawberries",
                        price = 16,
                        sale = 20,
                        isFavorite = false
                    ),
                    DonutUiState(
                        id = 2,
                        name = "Chocolate Glaze",
                        image = R.drawable.chocolate_glaze_donut,
                        description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                        price = 29,
                        sale = 20,
                        isFavorite = false
                    ),
                    DonutUiState(
                        id = 3,
                        name = "Pink Donut",
                        image = R.drawable.pink_donut,
                        description = "These Baked Strawberry Donuts are filled with fresh strawberries",
                        price = 16,
                        sale = 20,
                        isFavorite = false
                    ),
                    DonutUiState(
                        id = 2,
                        name = "Coffee Donut",
                        image = R.drawable.coffee_donut,
                        description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                        price = 29,
                        sale = 20,
                        isFavorite = false
                    )
                )
            )
        }
    }
}