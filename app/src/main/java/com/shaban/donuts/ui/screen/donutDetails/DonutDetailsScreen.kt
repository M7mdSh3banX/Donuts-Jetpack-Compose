package com.shaban.donuts.ui.screen.donutDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaban.donuts.R
import com.shaban.donuts.ui.theme.BackgroundColor
import com.shaban.donuts.ui.theme.Black
import com.shaban.donuts.ui.theme.Primary
import com.shaban.donuts.ui.theme.Secondary
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

    DonutDetailsContent(
        state = state,
        onClickFavoriteIcon = viewModel::onClickFavoriteIcon,
        onClickIncreaseQuantity = viewModel::onIncreaseQuantity,
        onClickDecreaseQuantity = viewModel::onDecreaseQuantity
    )
}

@Composable
fun DonutDetailsContent(
    state: DonutUiState,
    onClickFavoriteIcon: (DonutUiState) -> Unit,
    onClickIncreaseQuantity: (DonutUiState) -> Unit,
    onClickDecreaseQuantity: (DonutUiState) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .weight(1F)
                .fillMaxSize()
        ) {
            IconButton(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .size(40.dp),
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Arrow back Icon",
                    tint = Primary
                )
            }

            Image(
                painter = painterResource(id = R.drawable.strawberry_wheel_donut),
                contentDescription = state.name,
                modifier = Modifier
                    .aspectRatio(1F)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
        }
            IconButton(
                modifier = Modifier
                    .padding(16.dp)
                    .size(45.dp)
                    .background(color = White, shape = RoundedCornerShape(10.dp))
                    .align(alignment = Alignment.End),
                onClick = { onClickFavoriteIcon(state) }
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = if (state.isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite),
                    contentDescription = "Arrow back Icon",
                    tint = Primary
                )
            }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1F)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(color = WhiteBackground)
                .padding(40.dp)
        ) {
            Text(text = "Strawberry Wheel", style = Typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "About Donut", style = Typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = state.description,
                style = Typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Quantity", style = Typography.bodyLarge)
            Row(
                modifier = Modifier.padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .background(color = White, shape = RoundedCornerShape(8.dp))
                        .size(40.dp),
                    onClick = { if (state.quantity > 1) onClickDecreaseQuantity(state) }
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_decrease),
                        contentDescription = "Arrow back Icon",
                    )
                }
                Box(
                    modifier = Modifier
                        .background(color = White, shape = RoundedCornerShape(8.dp))
                        .size(40.dp)
                ) {
                    Text(
                        text = state.quantity.toString(),
                        style = Typography.bodyLarge,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                IconButton(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .background(color = Black, shape = RoundedCornerShape(8.dp))
                        .size(40.dp),
                    onClick = { onClickIncreaseQuantity(state) }
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_increase),
                        contentDescription = "Arrow back Icon",
                        tint = White
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.weight(1F))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "£${state.totalPrice}",
                    style = Typography.titleMedium.copy(color = Black),
                )
                Spacer(modifier = Modifier.width(24.dp))
                Button(
                    modifier = Modifier,
                    onClick = { },
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = ButtonDefaults.buttonColors(Secondary),
                ) {
                    Text(
                        text = "Add to Cart",
                        color = White,
                        style = Typography.labelLarge
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDonutDetailsScreen() {
    DonutDetailsScreen()
}