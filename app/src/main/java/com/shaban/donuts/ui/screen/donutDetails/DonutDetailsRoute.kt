package com.shaban.donuts.ui.screen.donutDetails

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "MovieDetailsRoute"

fun NavController.navigateToDonutDetailsScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.donutDetailsRoute() {
    composable(route = ROUTE) {
        DonutDetailsScreen()
    }
}