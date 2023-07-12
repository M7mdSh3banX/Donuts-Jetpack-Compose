package com.shaban.donuts.ui.screen.home.composable

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaban.donuts.R
import com.shaban.donuts.ui.screen.home.DonutUiState
import com.shaban.donuts.ui.theme.BabyBlue
import com.shaban.donuts.ui.theme.Black
import com.shaban.donuts.ui.theme.Black60
import com.shaban.donuts.ui.theme.Primary
import com.shaban.donuts.ui.theme.Typography
import com.shaban.donuts.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonutLargeItem(
    donutState: DonutUiState,
    cardBackground: Color,
    onClickDonutCard: (DonutUiState) -> Unit = { },
    onClickFavorite: (Int) -> Unit = { }
) {
    Box(
        modifier = Modifier
            .width(193.dp)
            .height(325.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(20.dp)),
            onClick = { onClickDonutCard(donutState) },
            colors = CardDefaults.cardColors(cardBackground),
            elevation = CardDefaults.cardElevation(0.dp)
        ) { }
        CompositionLocalProvider(
            LocalMinimumTouchTargetEnforcement provides false,
        ) {
            IconButton(
                modifier = Modifier
                    .padding(16.dp)
                    .size(35.dp)
                    .background(color = White, shape = CircleShape),
                onClick = { onClickFavorite(donutState.id) },
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(
                        id = if (donutState.isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_outlined),
                        contentDescription = stringResource(R.string.favorite_icon),
                        tint = Primary
                    )
            }
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Card(
                modifier = Modifier
                    .background(Transparent)
                    .offset(x = 84.dp),
                colors = CardDefaults.cardColors(Transparent),
            ) {
                Image(
                    painter = painterResource(id = donutState.image),
                    contentDescription = "Donut Name",
                    modifier = Modifier
                        .aspectRatio(1F),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = donutState.name,
                style = Typography.bodyMedium,
                color = Black
            )
            Text(
                text = donutState.description,
                style = Typography.labelSmall.copy(Black60),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "$${donutState.sale}",
                    style = Typography.labelMedium.copy(Black60),
                    textDecoration = TextDecoration.LineThrough
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "\$${donutState.price}",
                    style = Typography.titleSmall.copy(Black),
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDonutItem() {
    DonutLargeItem(
        donutState = DonutUiState(
            id = 2,
            name = "Chocolate Glaze",
            image = R.drawable.chocolate_glaze_donut,
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
            price = 29,
            sale = 20,
            isFavorite = false
        ), cardBackground = BabyBlue
    )
}