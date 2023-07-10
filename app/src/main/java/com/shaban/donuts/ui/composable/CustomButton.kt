package com.shaban.donuts.ui.composable

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shaban.donuts.R
import com.shaban.donuts.ui.theme.Secondary
import com.shaban.donuts.ui.theme.Typography
import com.shaban.donuts.ui.theme.White

@Composable
fun CustomButton(
    onClick: () -> Unit,
    buttonColor: Color = Secondary,
    text: String,
    textColor: Color = White,
) {
    Button(
        modifier = Modifier.height(56.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(buttonColor),
    ) {
        Text(
            text = text,
            color = textColor,
            style = Typography.labelLarge
        )
    }
}