package com.shaban.donuts.ui.screen.donutDetails

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DonutViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(DonutUiState())
    val state = _state.asStateFlow()

    init {
        getDonutDetails()
    }

    private fun getDonutDetails() {
        _state.update {
            it.copy(
                name = "Strawberry Wheel",
                description = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                price = 16.0,
            )
        }
    }

    fun onClickFavoriteIcon(donut: DonutUiState) =
        _state.update { it.copy(isFavorite = !donut.isFavorite) }

    fun onIncreaseQuantity(donut: DonutUiState) =
        _state.update {
            val newQuantity = donut.quantity + 1
            val newPrice = donut.price + 16.0

            it.copy(
                quantity = newQuantity,
                price = newPrice
            )
        }

    fun onDecreaseQuantity(donut: DonutUiState) =
        _state.update {
            val newQuantity = donut.quantity - 1
            val newPrice = donut.price - 16.0

            it.copy(
                quantity = newQuantity,
                price = newPrice
            )
        }
}