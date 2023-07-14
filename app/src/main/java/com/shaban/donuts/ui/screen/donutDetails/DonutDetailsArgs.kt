package com.shaban.donuts.ui.screen.donutDetails

import androidx.lifecycle.SavedStateHandle

class DonutDetailsArgs(savedStateHandle: SavedStateHandle) {

    val donutId: String = checkNotNull(savedStateHandle[DONUT_ID])

    companion object {
        const val DONUT_ID = "donut_id"
    }
}