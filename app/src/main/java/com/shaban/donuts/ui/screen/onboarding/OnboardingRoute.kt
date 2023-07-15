package com.shaban.donuts.ui.screen.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.shaban.donuts.ui.navigation.ONBOARDING_ROUTE

fun NavGraphBuilder.onboardingRoute() {
    composable(route = ONBOARDING_ROUTE) {
        OnboardingScreen()
    }
}