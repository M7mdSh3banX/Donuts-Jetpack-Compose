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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaban.donuts.R
import com.shaban.donuts.ui.theme.BabyBlue
import com.shaban.donuts.ui.theme.Black
import com.shaban.donuts.ui.theme.Black60
import com.shaban.donuts.ui.theme.Primary
import com.shaban.donuts.ui.theme.Typography
import com.shaban.donuts.ui.theme.White

@Composable
fun DonutItem() {
    Box(
        modifier = Modifier
            .width(193.dp)
            .height(325.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(20.dp)),
            colors = CardDefaults.cardColors(BabyBlue),
            elevation = CardDefaults.cardElevation(0.dp)
        ) { }
        IconButton(
            modifier = Modifier
                .padding(16.dp)
                .size(45.dp)
                .background(color = White, shape = CircleShape),
            onClick = { }
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = stringResource(R.string.favorite_icon),
                tint = Primary
            )
        }
        Card(
            modifier = Modifier
                .background(Transparent)
                .offset(x = 72.dp),
            colors = CardDefaults.cardColors(Transparent),
        ) {
            Image(
                painter = painterResource(id = R.drawable.strawberry_wheel_donut),
                contentDescription = "Donut Name",
                modifier = Modifier.aspectRatio(0.8F),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Strawberry Wheel",
                style = Typography.bodyMedium,
                color = Black
            )
            Text(
                text = "These Baked Strawberry Donuts are filled with fresh strawberries",
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
                    text = "$20",
                    style = Typography.labelMedium.copy(Black60),
                    textDecoration = TextDecoration.LineThrough
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "$16",
                    style = Typography.titleSmall.copy(Black),
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDonutItem() {
    DonutItem()
}