package com.shaban.donuts.ui.screen.donutDetails

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaban.donuts.R
import com.shaban.donuts.ui.composable.CustomButton
import com.shaban.donuts.ui.composable.SpacingVertical16
import com.shaban.donuts.ui.theme.BackgroundColor
import com.shaban.donuts.ui.theme.Black
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
        Box(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
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
                        contentDescription = stringResource(R.string.arrow_back_icon),
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
                    .padding(40.dp)
            ) {
                Text(text = state.name, style = Typography.titleMedium)
                SpacingVertical16()
                Text(text = stringResource(id = R.string.about_donut), style = Typography.bodyLarge)
                SpacingVertical16()
                Text(
                    text = state.description,
                    style = Typography.bodySmall
                )
                SpacingVertical16()
                Text(text = stringResource(id = R.string.quantity), style = Typography.bodyLarge)
                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .background(color = White, shape = RoundedCornerShape(8.dp))
                            .size(45.dp),
                        onClick = { if (state.quantity > 1) onClickDecreaseQuantity(state) }
                    ) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.ic_decrease),
                            contentDescription = stringResource(R.string.decrease_icon),
                        )
                    }
                    Box(
                        modifier = Modifier
                            .background(color = White, shape = RoundedCornerShape(8.dp))
                            .size(45.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AnimatedContent(
                            targetState = state.quantity,
                            transitionSpec = {
                                flipAnimation().using(
                                    SizeTransform(clip = true)
                                )
                            }
                        ) { quantity ->
                            Text(
                                text = quantity.toString(),
                                style = Typography.bodyLarge,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                    IconButton(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .background(color = Black, shape = RoundedCornerShape(8.dp))
                            .size(45.dp),
                        onClick = { onClickIncreaseQuantity(state) }
                    ) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.ic_increase),
                            contentDescription = stringResource(R.string.increase_icon),
                            tint = White
                        )
                    }
                }
                SpacingVertical16()
                Spacer(modifier = Modifier.weight(1F))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AnimatedContent(
                        targetState = state.totalPrice,
                        transitionSpec = {
                            flipAnimation().using(
                                SizeTransform(clip = true)
                            )
                        }
                    ) { totalPrice ->
                        Text(
                            text = "£$totalPrice",
                            style = Typography.titleMedium.copy(color = Black),
                        )
                    }
                    Spacer(modifier = Modifier.width(24.dp))
                    CustomButton(onClick = { }, text = stringResource(id = R.string.add_to_cart))
                }
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
                    painter = painterResource(id = if (state.isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite),
                    contentDescription = stringResource(R.string.favorite_icon),
                    tint = Primary
                )
            }
        }
    }
}

private fun flipAnimation(
    duration: Int = 500
): ContentTransform {
    return (slideInVertically(animationSpec = tween(durationMillis = duration)) { height -> height } + fadeIn(
        animationSpec = tween(durationMillis = duration)
    )).togetherWith(slideOutVertically(animationSpec = tween(durationMillis = duration)) { height -> -height } + fadeOut(
        animationSpec = tween(durationMillis = duration)
    ))
}

@Preview
@Composable
fun PreviewDonutDetailsScreen() {
    DonutDetailsScreen()
}