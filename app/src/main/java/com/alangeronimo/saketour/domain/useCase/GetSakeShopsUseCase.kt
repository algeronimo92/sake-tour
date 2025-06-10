package com.alangeronimo.saketour.domain.useCase

import com.alangeronimo.saketour.domain.model.SakeShop
import com.alangeronimo.saketour.domain.repository.SakeShopRepository

class GetSakeShopsUseCase(
    private val repository: SakeShopRepository
) {
    suspend operator fun invoke(): List<SakeShop> {
        return repository.getSakeShops()
    }
}