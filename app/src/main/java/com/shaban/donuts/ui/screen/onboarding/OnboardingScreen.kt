package com.shaban.donuts.ui.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaban.donuts.R
import com.shaban.donuts.ui.composable.CustomButton
import com.shaban.donuts.ui.composable.SpacingVertical16
import com.shaban.donuts.ui.composable.SpacingVertical60
import com.shaban.donuts.ui.theme.BackgroundColor
import com.shaban.donuts.ui.theme.Black
import com.shaban.donuts.ui.theme.Secondary
import com.shaban.donuts.ui.theme.Typography
import com.shaban.donuts.ui.theme.White

@Composable
fun OnboardingScreen() {
    val systemUiControl = rememberSystemUiController()
    systemUiControl.setStatusBarColor(color = Color.Transparent, darkIcons = true)

    OnboardingContent()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.donuts),
                contentDescription = "Onboarding Image",
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .aspectRatio(4F / 5F)
                    .basicMarquee(
                        iterations = Int.MAX_VALUE, //infinity
                        delayMillis = 0,
                        initialDelayMillis = 0,
                        velocity = 100.dp,
                        spacing = MarqueeSpacing(0.dp)
                    ),
                contentScale = ContentScale.Fit
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = stringResource(R.string.gonuts_with_donuts),
                    style = Typography.titleLarge
                )
                SpacingVertical16()
                Text(
                    text = stringResource(R.string.gonuts_info),
                    style = Typography.bodyLarge.copy(color = Secondary)
                )
                SpacingVertical60()
                CustomButton(
                    onClick = { },
                    buttonColor = White,
                    text = stringResource(id = R.string.get_started),
                    textColor = Black,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen()
}