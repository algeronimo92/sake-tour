package com.alangeronimo.saketour.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.alangeronimo.designsystem.components.SakeListItem
import com.alangeronimo.domain.model.SakeShop
import com.alangeronimo.saketour.presentation.viewmodel.SakeShopViewModel

@Composable
fun SakeShopListScreen(
    viewModel: SakeShopViewModel,
    onItemClick: (SakeShop) -> Unit
) {
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
    SakeListItem(
        shop,
        onClick = onClick
    )
}
