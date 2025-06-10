package com.alangeronimo.saketour.data.repository

import android.content.Context
import android.util.Log
import com.alangeronimo.saketour.data.dto.SakeShopDto
import com.alangeronimo.saketour.domain.model.SakeShop
import com.alangeronimo.saketour.domain.repository.SakeShopRepository
import com.alangeronimo.saketour.network.SakeShopApi
import com.alangeronimo.saketour.commons.readBackupJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SakeShopRepositoryImpl(
    private val api: SakeShopApi,
    private val context: Context,
    private val gson: Gson
) : SakeShopRepository {
    override suspend fun getSakeShops(): List<SakeShop> {
        return try {
            api.getSakeShops().map { it.toDomain() }
        } catch (e: Exception) {
            Log.e("Repository", "API failed: ${e.message}. Loading fallback JSON.")
            val backupJson = context.readBackupJson("sake_shops_backup.json")
            val type = object : TypeToken<List<SakeShopDto>>() {}.type
            gson.fromJson<List<SakeShopDto>>(backupJson, type).map { it.toDomain() }
        }
    }
}
