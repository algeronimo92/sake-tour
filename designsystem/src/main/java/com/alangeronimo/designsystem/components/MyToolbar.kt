package com.alangeronimo.designsystem.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alangeronimo.designsystem.ui.theme.SakeTourTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToolbar(
    title: String,
    hasBackIcon: Boolean = true,
    onBackClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(title, style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
        },
        modifier = Modifier.shadow(4.dp),
        navigationIcon = {
            if(hasBackIcon) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
internal fun ToolBarPreview() {
    val title = "Sake Shops"
    SakeTourTheme {
        MyToolbar(
            title = title,
            onBackClick = {}
        )
    }
}
