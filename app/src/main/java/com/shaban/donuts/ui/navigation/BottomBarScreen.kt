package com.shaban.donuts.ui.navigation

import com.shaban.donuts.R

sealed class BottomBarScreen(
    val route: String,
    val icon: Int,
) {
    object Home : BottomBarScreen(
        route = "Home",
        icon = R.drawable.ic_home
    )

    object Favorite : BottomBarScreen(
        route = "Favorite",
        icon = R.drawable.ic_favorite_with_notch
    )

    object Notification : BottomBarScreen(
        route = "Notification",
        icon = R.drawable.ic_notification
    )

    object Cart : BottomBarScreen(
        route = "Cart",
        icon = R.drawable.ic_cart
    )

    object Profile : BottomBarScreen(
        route = "Profile",
        icon = R.drawable.ic_profile
    )
}
