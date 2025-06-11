package com.alangeronimo.domain.repository

import com.alangeronimo.domain.model.SakeShop

interface SakeShopRepository {
    suspend fun getSakeShops(): List<SakeShop>
}
