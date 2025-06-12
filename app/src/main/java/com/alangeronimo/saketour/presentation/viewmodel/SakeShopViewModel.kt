package com.alangeronimo.saketour.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alangeronimo.domain.model.SakeShop
import com.alangeronimo.domain.useCase.GetSakeShopsUseCase
import com.alangeronimo.saketour.presentation.state.SakeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SakeShopViewModel(private val getSakeShopsUseCase: GetSakeShopsUseCase) : ViewModel(), ISakeShopViewModel {

    private val _state = MutableStateFlow(SakeUiState())
    override val state: StateFlow<SakeUiState> = _state

    init {
        loadSakeShops()
    }

    fun loadSakeShops() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val shops = getSakeShopsUseCase()
                _state.value = SakeUiState(sakeShops = shops)
            } catch (e: Exception) {
                _state.value = SakeUiState(error = "Failed to load shops: ${e.message}")
            }
        }
    }

    override fun findShopByName(name: String): SakeShop? {
        return state.value.sakeShops.find { it.name == name }
    }
}
