package com.alangeronimo.saketour.network

import com.alangeronimo.saketour.data.dto.SakeShopDto
import retrofit2.http.GET

interface SakeShopApi {
    @GET("sake_shops.json")
    suspend fun getSakeShops(): List<SakeShopDto>
}