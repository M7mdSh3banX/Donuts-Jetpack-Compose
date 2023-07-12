package com.shaban.donuts.ui.screen.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaban.donuts.R
import com.shaban.donuts.ui.composable.SpacingVertical4
import com.shaban.donuts.ui.screen.home.DonutUiState
import com.shaban.donuts.ui.theme.Black60
import com.shaban.donuts.ui.theme.Primary
import com.shaban.donuts.ui.theme.Typography
import com.shaban.donuts.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonutISmallItem(
    donutState: DonutUiState,
    onClickDonutCard: (DonutUiState) -> Unit = { },
) {
    Box(
        modifier = Modifier
            .width(138.dp)
            .height(111.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    shape = RoundedCornerShape(
                        topEnd = 20.dp,
                        topStart = 20.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                ),
            onClick = { onClickDonutCard(donutState) },
            colors = CardDefaults.cardColors(White),
            elevation = CardDefaults.cardElevation(0.dp)
        ) { }
        Card(
            modifier = Modifier
                .size(80.dp)
                .background(Transparent)
                .offset(0.dp, (-56).dp),
            colors = CardDefaults.cardColors(Transparent)
        ) {
            Image(
                painter = painterResource(id = donutState.image),
                contentDescription = "Donut",
                modifier = Modifier.fillMaxSize(),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = donutState.name,
                style = Typography.bodySmall.copy(Black60),
            )
            SpacingVertical4()
            Text(
                text = "$${donutState.price}",
                style = Typography.labelMedium.copy(color = Primary),
            )
        }
    }
}

@Preview
@Composable
fun PreviewDonutISmallItem() {
    DonutISmallItem(
        donutState = DonutUiState(
            id = 2,
            name = "Chocolate Glaze",
            image = R.drawable.chocolate_cherry_donut,
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
            price = 29,
            sale = 20,
            isFavorite = false
        )
    )
}