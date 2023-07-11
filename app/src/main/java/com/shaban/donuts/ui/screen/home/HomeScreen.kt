package com.shaban.donuts.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaban.donuts.R
import com.shaban.donuts.ui.composable.SpacingVertical16
import com.shaban.donuts.ui.composable.SpacingVertical60
import com.shaban.donuts.ui.screen.home.composable.DonutItem
import com.shaban.donuts.ui.screen.home.composable.HomeHeader
import com.shaban.donuts.ui.theme.Black
import com.shaban.donuts.ui.theme.Typography
import com.shaban.donuts.ui.theme.WhiteBackground

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val systemUiControl = rememberSystemUiController()
    systemUiControl.setStatusBarColor(color = Color.Transparent, darkIcons = true)

    HomeContent(state = state)
}

@Composable
fun HomeContent(
    state: HomeUiState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteBackground)
    ) {
        Column(modifier = Modifier.padding(horizontal = 32.dp, vertical = 54.dp)) {
            HomeHeader(
                title = stringResource(R.string.header_title),
                subtitle = stringResource(R.string.header_subtitle),
                icon = painterResource(R.drawable.ic_search),
                onClickSearch = { }
            )
            SpacingVertical16()
            Text(text = "Today Offers", style = Typography.titleSmall.copy(color = Black))
            /*LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 24.dp)
            ) {
                items() {

                }
            }*/
            SpacingVertical16()
            Row {
                DonutItem()
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}