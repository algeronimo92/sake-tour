package com.alangeronimo.data.network

import com.alangeronimo.data.dto.SakeShopDto
import retrofit2.http.GET

interface SakeShopApi {
    @GET("sake_shops.json")
    suspend fun getSakeShops(): List<SakeShopDto>
}
