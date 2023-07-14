package com.shaban.donuts.ui.screen.donutDetails

import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "DonutDetailsRoute"

fun NavController.navigateToDonutDetailsScreen(donutId: Int) {
    navigate("$ROUTE/$donutId")
}

fun NavGraphBuilder.donutDetailsRoute() {
    composable(
        route = "$ROUTE/{${DonutDetailsArgs.DONUT_ID}}",
        arguments = listOf(navArgument(DonutDetailsArgs.DONUT_ID) { NavType.IntType })
    ) {
        DonutDetailsScreen()
    }
}