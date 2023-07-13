package com.shaban.donuts.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shaban.donuts.ui.main.LocalNavigationProvider
import com.shaban.donuts.ui.screen.donutDetails.DonutDetailsScreen
import com.shaban.donuts.ui.screen.home.HomeScreen
import com.shaban.donuts.ui.screen.onboarding.OnboardingScreen

@Composable
fun BottomNavGraph() {
    val navController = LocalNavigationProvider.current

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) { HomeScreen() }
        composable(route = BottomBarScreen.Favorite.route) { }
        composable(route = BottomBarScreen.Notification.route) { }
        composable(route = BottomBarScreen.Cart.route) { }
        composable(route = BottomBarScreen.Profile.route) { }
    }
}