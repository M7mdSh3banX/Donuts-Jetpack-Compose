package com.shaban.donuts.ui.screen.donutDetails

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaban.donuts.R
import com.shaban.donuts.ui.composable.SpacingVertical16
import com.shaban.donuts.ui.main.LocalNavigationProvider
import com.shaban.donuts.ui.screen.donutDetails.composable.Footer
import com.shaban.donuts.ui.screen.donutDetails.composable.Header
import com.shaban.donuts.ui.screen.donutDetails.composable.QuantityButtons
import com.shaban.donuts.ui.theme.BackgroundColor
import com.shaban.donuts.ui.theme.Primary
import com.shaban.donuts.ui.theme.Typography
import com.shaban.donuts.ui.theme.White
import com.shaban.donuts.ui.theme.WhiteBackground

@Composable
fun DonutDetailsScreen(
    viewModel: DonutViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val systemUiControl = rememberSystemUiController()
    systemUiControl.setStatusBarColor(color = Color.Transparent, darkIcons = true)

    val navController = LocalNavigationProvider.current

    DonutDetailsContent(
        state = state,
        onClickFavoriteIcon = viewModel::onClickFavoriteIcon,
        onClickIncreaseQuantity = viewModel::onIncreaseQuantity,
        onClickDecreaseQuantity = viewModel::onDecreaseQuantity,
        onClickExit = { navController.navigateUp() }
    )
}

@Composable
fun DonutDetailsContent(
    state: DonutDetailsUiState,
    onClickFavoriteIcon: (DonutDetailsUiState) -> Unit,
    onClickIncreaseQuantity: (DonutDetailsUiState) -> Unit,
    onClickDecreaseQuantity: (DonutDetailsUiState) -> Unit,
    onClickExit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Box(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth()
        ) {
            Header(donutState = state, onClickExit = onClickExit)
        }

        Box(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(color = WhiteBackground)
                    .padding(top = 40.dp, start = 40.dp, end = 40.dp, bottom = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = state.name, style = Typography.titleMedium)
                SpacingVertical16()
                Text(text = stringResource(id = R.string.about_donut), style = Typography.bodyLarge)
                SpacingVertical16()
                Text(text = state.description, style = Typography.bodySmall)
                SpacingVertical16()
                Text(text = stringResource(id = R.string.quantity), style = Typography.bodyLarge)
                QuantityButtons(
                    donutState = state,
                    onClickDecreaseQuantity = onClickDecreaseQuantity,
                    onClickIncreaseQuantity = onClickIncreaseQuantity
                )
                SpacingVertical16()
                Spacer(modifier = Modifier.weight(1F))
                Footer(donutState = state)
            }

            IconButton(
                modifier = Modifier
                    .offset(y = (-24).dp)
                    .padding(end = 16.dp)
                    .size(45.dp)
                    .background(color = White, shape = RoundedCornerShape(10.dp))
                    .align(alignment = Alignment.TopEnd),
                onClick = { onClickFavoriteIcon(state) }
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = if (state.isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_outlined),
                    contentDescription = stringResource(R.string.favorite_icon),
                    tint = Primary
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDonutDetailsScreen() {
    DonutDetailsScreen()
}