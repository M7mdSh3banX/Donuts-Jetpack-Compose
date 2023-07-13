package com.shaban.donuts.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shaban.donuts.ui.main.LocalNavigationProvider
import com.shaban.donuts.ui.screen.donutDetails.donutDetailsRoute
import com.shaban.donuts.ui.screen.home.homeRoute

@Composable
fun BottomNavGraph() {
    val navController = LocalNavigationProvider.current

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        homeRoute()
        composable(route = BottomBarScreen.Favorite.route) { }
        composable(route = BottomBarScreen.Notification.route) { }
        composable(route = BottomBarScreen.Cart.route) { }
        composable(route = BottomBarScreen.Profile.route) { }
        donutDetailsRoute()
    }
}