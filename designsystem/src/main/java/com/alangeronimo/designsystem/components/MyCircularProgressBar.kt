package com.alangeronimo.designsystem.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alangeronimo.designsystem.ui.theme.Accent

@Preview
@Composable
fun MyCircularProgressBar(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        color = Accent,
        modifier = modifier,
    )
}
