package com.alangeronimo.domain.useCase

import com.alangeronimo.domain.model.SakeShop
import com.alangeronimo.domain.repository.SakeShopRepository

class GetSakeShopsUseCase(
    private val repository: SakeShopRepository
) {
    suspend operator fun invoke(): List<SakeShop> {
        return repository.getSakeShops()
    }
}
