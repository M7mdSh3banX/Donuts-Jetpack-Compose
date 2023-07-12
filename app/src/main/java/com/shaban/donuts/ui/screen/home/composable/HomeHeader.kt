package com.shaban.donuts.ui.screen.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaban.donuts.R
import com.shaban.donuts.ui.composable.SpacingVertical4
import com.shaban.donuts.ui.theme.BackgroundColor
import com.shaban.donuts.ui.theme.Black60
import com.shaban.donuts.ui.theme.Primary
import com.shaban.donuts.ui.theme.Typography

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    icon: Painter,
    onClickSearch: () -> Unit
) {
    Row(
        modifier = Modifier.padding(24.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = modifier.padding(end = 48.dp)) {
            Text(text = title, style = Typography.titleMedium)
            SpacingVertical4()
            Text(text = subtitle, style = Typography.bodySmall.copy(color = Black60))
        }
        IconButton(
            modifier = Modifier
                .size(45.dp)
                .background(color = BackgroundColor, shape = RoundedCornerShape(10.dp)),
            onClick = onClickSearch
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = icon,
                contentDescription = stringResource(R.string.favorite_icon),
                tint = Primary
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeHeader() {
    HomeHeader(
        title = stringResource(R.string.header_title),
        subtitle = stringResource(R.string.header_subtitle),
        icon = painterResource(R.drawable.ic_search),
        onClickSearch = { }
    )
}