package com.shaban.donuts.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.shaban.donuts.ui.main.LocalNavigationProvider
import com.shaban.donuts.ui.screen.donutDetails.navigateToDonutDetailsScreen
import com.shaban.donuts.ui.screen.home.composable.DonutISmallItem
import com.shaban.donuts.ui.screen.home.composable.DonutLargeItem
import com.shaban.donuts.ui.screen.home.composable.HomeHeader
import com.shaban.donuts.ui.theme.BabyBlue
import com.shaban.donuts.ui.theme.BackgroundColor
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

    val navController = LocalNavigationProvider.current

    HomeContent(
        state = state,
        viewModel::onClickFavoriteIcon,
        onClickDonut = { navController.navigateToDonutDetailsScreen(it.id) }
    )
}

@Composable
fun HomeContent(
    state: HomeUiState,
    onClickFavoriteIcon: (Int) -> Unit,
    onClickDonut: (DonutUiState) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteBackground)
    ) {
        Column {
            HomeHeader(
                title = stringResource(R.string.header_title),
                subtitle = stringResource(R.string.header_subtitle),
                icon = painterResource(R.drawable.ic_search),
                onClickSearch = { }
            )
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Text(
                    modifier = Modifier.padding(24.dp),
                    text = stringResource(R.string.today_offers),
                    style = Typography.titleSmall.copy(color = Black)
                )
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(72.dp),
                    contentPadding = PaddingValues(start = 24.dp, end = 72.dp)
                ) {
                    items(state.largeDonuts) { donut ->
                        if (state.largeDonuts.indexOf(donut) % 2 == 0)
                            DonutLargeItem(
                                donutState = donut,
                                cardBackground = BabyBlue,
                                onClickFavorite = onClickFavoriteIcon,
                                onClickDonutCard = onClickDonut
                            )
                        else
                            DonutLargeItem(
                                donutState = donut,
                                cardBackground = BackgroundColor,
                                onClickFavorite = onClickFavoriteIcon,
                                onClickDonutCard = onClickDonut
                            )
                    }
                }
                Text(
                    modifier = Modifier.padding(24.dp),
                    text = stringResource(R.string.donuts),
                    style = Typography.titleSmall.copy(color = Black)
                )
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(24.dp)
                ) {
                    items(state.smallDonuts) { donut ->
                        DonutISmallItem(donutState = donut, onClickDonutCard = onClickDonut)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}