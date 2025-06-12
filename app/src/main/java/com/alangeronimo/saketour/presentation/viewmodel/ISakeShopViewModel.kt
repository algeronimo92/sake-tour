package com.alangeronimo.saketour.presentation.viewmodel

import com.alangeronimo.domain.model.SakeShop
import com.alangeronimo.saketour.presentation.state.SakeUiState
import kotlinx.coroutines.flow.StateFlow

interface ISakeShopViewModel {
    val state: StateFlow<SakeUiState>

    fun findShopByName(name: String): SakeShop?
}
