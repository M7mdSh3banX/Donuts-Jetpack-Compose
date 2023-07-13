package com.shaban.donuts.ui.screen.home

import androidx.lifecycle.ViewModel
import com.shaban.donuts.data.ChocolateCherry
import com.shaban.donuts.data.ChocolateGlaze
import com.shaban.donuts.data.CoffeeDonut
import com.shaban.donuts.data.PinkDonut
import com.shaban.donuts.data.StrawberryCoco
import com.shaban.donuts.data.StrawberryRain
import com.shaban.donuts.data.StrawberryWheel
import com.shaban.donuts.data.largeDonuts
import com.shaban.donuts.data.smallDonuts
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
        getDonutItemsDetails()
    }

    private fun getDonutItemsDetails() {
        _state.update { it.copy(largeDonuts = largeDonuts, smallDonuts = smallDonuts) }
    }

    fun onClickFavoriteIcon(donutId: Int) {
        _state.update { currentState ->
            val updatedDonuts = currentState.largeDonuts.map { donut ->
                if (donut.id == donutId) {
                    donut.copy(isFavorite = !donut.isFavorite)
                } else {
                    donut
                }
            }
            currentState.copy(largeDonuts = updatedDonuts)
        }
    }
}