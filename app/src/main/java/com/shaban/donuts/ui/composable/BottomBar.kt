package com.shaban.donuts.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shaban.donuts.ui.main.LocalNavigationProvider
import com.shaban.donuts.ui.navigation.BottomBarScreen
import com.shaban.donuts.ui.theme.Black
import com.shaban.donuts.ui.theme.Secondary
import com.shaban.donuts.ui.theme.WhiteBackground

@Composable
fun BottomBar() {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favorite,
        BottomBarScreen.Notification,
        BottomBarScreen.Cart,
        BottomBarScreen.Profile,
    )
    val screensRoutes = listOf(
        BottomBarScreen.Home.route,
        BottomBarScreen.Favorite.route,
        BottomBarScreen.Notification.route,
        BottomBarScreen.Cart.route,
        BottomBarScreen.Profile.route
    )

    val navController = LocalNavigationProvider.current

    val navStackByEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackByEntry?.destination
    // State of bottomBar, set state to false, if current page route is "tickets screen"
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    when (navStackByEntry?.destination?.route) {
        in screensRoutes -> bottomBarState.value = true
        else -> bottomBarState.value = false
    }

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            Row(
                modifier = Modifier
                    .background(WhiteBackground)
                    .padding(vertical = 16.dp, horizontal = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                screens.forEach { screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                    )
                }
            }
        }
    )
}

@Composable
private fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
) {
    val navController = LocalNavigationProvider.current

    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val background = if (selected) Secondary else Transparent
    val contentColor = if (selected) WhiteBackground else Black

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                })
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = "Bottom Bar Icon",
                tint = contentColor
            )
        }
    }
}