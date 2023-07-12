package com.shaban.donuts.ui.screen.home

import androidx.lifecycle.ViewModel
import com.shaban.donuts.R
import com.shaban.donuts.ui.screen.donutDetails.DonutDetailsUiState
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
        val donuts = listOf(
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
                id = 4,
                name = "Coffee Donut",
                image = R.drawable.coffee_donut,
                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                price = 29,
                sale = 20,
                isFavorite = false
            ),
            DonutUiState(
                id = 5,
                name = "Chocolate Cherry",
                image = R.drawable.chocolate_cherry_donut,
                price = 22,
            ),
            DonutUiState(
                id = 6,
                name = "Strawberry Rain",
                image = R.drawable.strawberry_rain_donut,
                price = 29,
            ),
            DonutUiState(
                id = 7,
                name = "Strawberry Coco",
                image = R.drawable.strawberry_coco_donut,
                price = 29,
            ),
        )
        _state.update { it.copy(donuts = donuts) }
    }

    fun onClickFavoriteIcon(donutId: Int) {
        _state.update { currentState ->
            val updatedDonuts = currentState.donuts.map { donut ->
                if (donut.id == donutId) {
                    donut.copy(isFavorite = !donut.isFavorite)
                } else {
                    donut
                }
            }
            currentState.copy(donuts = updatedDonuts)
        }
    }
}