package com.shaban.donuts.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaban.donuts.ui.composable.BottomBar
import com.shaban.donuts.ui.navigation.BottomNavGraph

val LocalNavigationProvider = staticCompositionLocalOf<NavHostController> {
    error("No navigation host controller provided.")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val systemUiControl = rememberSystemUiController()
    systemUiControl.setStatusBarColor(color = Transparent, darkIcons = true)

    CompositionLocalProvider(LocalNavigationProvider provides rememberNavController()) {
        Scaffold(
            Modifier.fillMaxHeight(),
            bottomBar = { BottomBar() },
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                BottomNavGraph()
            }
        }
    }
}