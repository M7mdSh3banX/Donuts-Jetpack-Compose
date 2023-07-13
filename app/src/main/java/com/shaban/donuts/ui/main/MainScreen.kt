package com.shaban.donuts.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaban.donuts.ui.composable.BottomBar
import com.shaban.donuts.ui.navigation.BottomNavGraph
import com.shaban.donuts.ui.screen.home.HomeUiState

val LocalNavigationProvider = staticCompositionLocalOf<NavHostController> {
    error("No navigation host controller provided.")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val systemUIController = rememberSystemUiController()
    systemUIController.setNavigationBarColor(color = Transparent)
    systemUIController.setStatusBarColor(color = Transparent)

    CompositionLocalProvider(LocalNavigationProvider provides rememberNavController()) {
        Scaffold(
            bottomBar = { BottomBar() },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                BottomNavGraph()
            }
        }
    }
}