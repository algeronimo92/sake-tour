package com.alangeronimo.saketour.presentation.state

import com.alangeronimo.domain.model.SakeShop

data class SakeUiState(
    val isLoading: Boolean = false,
    val sakeShops: List<com.alangeronimo.domain.model.SakeShop> = emptyList(),
    val error: String? = null
)
