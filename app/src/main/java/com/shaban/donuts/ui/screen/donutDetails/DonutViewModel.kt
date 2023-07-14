package com.shaban.donuts.ui.screen.donutDetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.shaban.donuts.data.largeDonuts
import com.shaban.donuts.data.smallDonuts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DonutViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(DonutDetailsUiState())
    val state = _state.asStateFlow()

    private val args = DonutDetailsArgs(savedStateHandle)

    init {
        getDonutDetailsById(args.donutId.toInt())
    }

    private fun getDonutDetailsById(id: Int) {
        val donut = findDonutById(id)
        if (donut != null) {
            _state.value = donut
            Log.e("TAG", _state.value.toString())
        } else {
            // Handle the case when donut with the specified ID is not found
        }
    }

    private fun findDonutById(id: Int): DonutDetailsUiState? {
        val donutList = largeDonuts + smallDonuts
        return donutList.toDonutDetailsUiState().find { it.id == id }
    }

    fun onClickFavoriteIcon(donut: DonutDetailsUiState) =
        _state.update { it.copy(isFavorite = !donut.isFavorite) }

    fun onIncreaseQuantity(donut: DonutDetailsUiState) =
        _state.update {
            val newQuantity = donut.quantity + 1
            val newPrice = donut.totalPrice + donut.price

            it.copy(
                quantity = newQuantity,
                totalPrice = newPrice
            )
        }

    fun onDecreaseQuantity(donut: DonutDetailsUiState) =
        _state.update {
            val newQuantity = donut.quantity - 1
            val newPrice = donut.totalPrice - donut.price

            it.copy(
                quantity = newQuantity,
                totalPrice = newPrice
            )
        }
}