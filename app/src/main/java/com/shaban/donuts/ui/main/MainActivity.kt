package com.shaban.donuts.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.shaban.donuts.ui.screen.donutDetails.DonutDetailsScreen
import com.shaban.donuts.ui.screen.onboarding.OnboardingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            //DonutDetailsScreen()
            OnboardingScreen()
        }
    }
}