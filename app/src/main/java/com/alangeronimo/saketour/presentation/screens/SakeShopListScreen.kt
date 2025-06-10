package com.alangeronimo.saketour.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alangeronimo.saketour.domain.model.SakeShop
import com.alangeronimo.saketour.presentation.viewmodel.SakeShopViewModel


@Composable
fun SakeShopListScreen(viewModel: SakeShopViewModel, onItemClick: (SakeShop) -> Unit) {
    val state by viewModel.state.collectAsState()
    when {
        state.isLoading -> CircularProgressIndicator()
        state.error != null -> Text("Error: ${state.error}")
        else -> LazyColumn {
            items(state.sakeShops) { shop ->
                ListItem(shop = shop, onClick = { onItemClick(shop) })
            }
        }
    }
}

@Composable
fun ListItem(shop: SakeShop, onClick: () -> Unit) {
    Card(modifier = Modifier.padding(8.dp).clickable(onClick = onClick)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(shop.name, style = MaterialTheme.typography.titleMedium)
            Text(shop.address, style = MaterialTheme.typography.bodySmall)
            Text("⭐ ${shop.rating}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
