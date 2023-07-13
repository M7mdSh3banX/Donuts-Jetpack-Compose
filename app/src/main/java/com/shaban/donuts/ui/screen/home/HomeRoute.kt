package com.shaban.donuts.ui.screen.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.shaban.donuts.ui.navigation.BottomBarScreen

fun NavGraphBuilder.homeRoute() {
    composable(route = BottomBarScreen.Home.route) {
        HomeScreen()
    }
}