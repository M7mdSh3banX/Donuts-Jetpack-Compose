package com.shaban.donuts.ui.screen.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "OnboardingRoute"

fun NavGraphBuilder.onboardingRoute() {
    composable(route = ROUTE) {
        OnboardingScreen()
    }
}