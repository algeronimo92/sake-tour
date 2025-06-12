package com.alangeronimo.saketour.presentation.state

import com.alangeronimo.domain.model.SakeShop

data class SakeUiState(
    val isLoading: Boolean = false,
    val sakeShops: List<SakeShop> = emptyList(),
    val error: String? = null,
)
