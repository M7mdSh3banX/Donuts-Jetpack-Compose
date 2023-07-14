package com.shaban.donuts.ui.screen.donutDetails.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shaban.donuts.R
import com.shaban.donuts.ui.screen.donutDetails.DonutDetailsUiState
import com.shaban.donuts.ui.theme.Primary

@Composable
fun Header(
    donutState: DonutDetailsUiState,
    modifier: Modifier = Modifier,
    onClickExit:() -> Unit
) {
    Column(
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxSize()
    ) {
        IconButton(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
                .size(40.dp),
            onClick = onClickExit
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = stringResource(R.string.arrow_back_icon),
                tint = Primary
            )
        }

        Image(
            painter = painterResource(id = donutState.image),
            contentDescription = donutState.name,
            modifier = Modifier
                .aspectRatio(1F)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
    }
}