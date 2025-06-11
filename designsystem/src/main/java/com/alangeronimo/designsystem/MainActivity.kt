package com.alangeronimo.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alangeronimo.designsystem.components.SakeListItem
import com.alangeronimo.designsystem.ui.theme.SakeTourTheme
import com.alangeronimo.domain.model.SakeShop

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InitView()
        }
    }
}

val sampleShop = SakeShop(
    name = "The Sake House",
    description = "Fine Japanese sake",
    picture = null,
    rating = 4.2f,
    address = "123 Main St, Anytown",
    googleMapsLink = "",
    website = ""
)

@Composable
fun InitView() {
    SakeTourTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column {
                Greeting(
                    name = "SakeListItem",
                    modifier = Modifier.padding(innerPadding)
                )
                ShowSakeListItem()
                ShowSakeListItem()
                ShowSakeListItem()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "This is $name",
        modifier = modifier
    )
}

@Composable
fun ShowSakeListItem(modifier: Modifier = Modifier) {
    SakeTourTheme {
        SakeListItem(
            shop = sampleShop,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    InitView()
}
