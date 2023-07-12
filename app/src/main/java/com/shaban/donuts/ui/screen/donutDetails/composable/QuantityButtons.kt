package com.shaban.donuts.ui.screen.donutDetails.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shaban.donuts.R
import com.shaban.donuts.ui.screen.donutDetails.DonutDetailsUiState
import com.shaban.donuts.ui.theme.Black
import com.shaban.donuts.ui.theme.Typography
import com.shaban.donuts.ui.theme.White

@Composable
fun QuantityButtons(
    donutState: DonutDetailsUiState,
    onClickDecreaseQuantity: (DonutDetailsUiState) -> Unit,
    onClickIncreaseQuantity: (DonutDetailsUiState) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = Modifier
                .padding(end = 20.dp)
                .background(color = White, shape = RoundedCornerShape(8.dp))
                .size(45.dp),
            onClick = { if (donutState.quantity > 1) onClickDecreaseQuantity(donutState) }
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
                targetState = donutState.quantity,
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
            onClick = { onClickIncreaseQuantity(donutState) }
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_increase),
                contentDescription = stringResource(R.string.increase_icon),
                tint = White
            )
        }
    }
}