package com.shaban.donuts.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaban.donuts.ui.composable.BottomBar
import com.shaban.donuts.ui.navigation.BottomNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val systemUIController = rememberSystemUiController()
    val navController = rememberNavController()

    systemUIController.setNavigationBarColor(color = Transparent)
    systemUIController.setStatusBarColor(color = Transparent)

    Scaffold(
        bottomBar = { BottomBar(navController = navController) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            BottomNavGraph(navController = navController)
        }
    }
}