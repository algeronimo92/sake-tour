package com.alangeronimo.saketour.presentation.state

import com.alangeronimo.domain.model.SakeShop

sealed class SakeUiEvent {
    object LoadShops : SakeUiEvent()

    data class LoadSuccess(val shops: List<SakeShop>) : SakeUiEvent()

    data class LoadFailed(val errorMessage: String) : SakeUiEvent()
}
