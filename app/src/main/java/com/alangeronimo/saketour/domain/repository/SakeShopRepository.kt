package com.alangeronimo.saketour.domain.repository

import com.alangeronimo.saketour.domain.model.SakeShop

interface SakeShopRepository {
    suspend fun getSakeShops(): List<SakeShop>
}
