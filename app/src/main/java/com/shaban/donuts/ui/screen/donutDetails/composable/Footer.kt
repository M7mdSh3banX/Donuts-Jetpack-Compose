package com.shaban.donuts.ui.screen.donutDetails.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shaban.donuts.R
import com.shaban.donuts.ui.composable.CustomButton
import com.shaban.donuts.ui.screen.donutDetails.DonutDetailsUiState
import com.shaban.donuts.ui.theme.Black
import com.shaban.donuts.ui.theme.Typography

@Composable
fun Footer(
    donutState: DonutDetailsUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AnimatedContent(
            targetState = donutState.totalPrice,
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