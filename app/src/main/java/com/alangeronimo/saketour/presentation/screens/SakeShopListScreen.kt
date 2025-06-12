package com.alangeronimo.saketour.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alangeronimo.designsystem.components.MyCircularProgressBar
import com.alangeronimo.designsystem.components.MyToolbar
import com.alangeronimo.designsystem.components.SakeListItem
import com.alangeronimo.designsystem.ui.theme.SakeTourTheme
import com.alangeronimo.domain.model.SakeShop
import com.alangeronimo.saketour.R
import com.alangeronimo.saketour.presentation.viewmodel.ISakeShopViewModel

@Composable
fun SakeShopListScreen(
    viewModel: ISakeShopViewModel,
    onItemClick: (SakeShop) -> Unit,
) {
    SakeTourTheme {
        Scaffold(
            topBar = {
                MyToolbar(
                    title = stringResource(id = R.string.list_screen_title),
                    hasBackIcon = false,
                    onBackClick = {},
                )
            },
        ) { paddingValues ->
            Content(viewModel, onItemClick, paddingValues)
        }
    }
}

@Composable
private fun Content(
    viewModel: ISakeShopViewModel,
    onItemClick: (SakeShop) -> Unit,
    paddingValues: PaddingValues,
) {
    val state by viewModel.state.collectAsState()
    Box(
        Modifier
            .fillMaxSize()
            .padding(paddingValues),
    ) {
        when {
            state.isLoading ->
                Box(Modifier.fillMaxSize()) {
                    MyCircularProgressBar(modifier = Modifier.align(Alignment.Center))
                }

            state.error != null ->
                Box(Modifier.fillMaxSize()) {
                    Text("Error: ${state.error}", modifier = Modifier.align(Alignment.Center))
                }

            else ->
                LazyColumn {
                    items(state.sakeShops) { shop ->
                        ListItem(shop = shop, onClick = { onItemClick(shop) })
                    }
                }
        }
    }
}

@Composable
fun ListItem(
    shop: SakeShop,
    onClick: () -> Unit,
) {
    SakeListItem(
        shop,
        onClick = onClick,
    )
}
