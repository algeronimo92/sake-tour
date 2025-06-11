package com.alangeronimo.data.repository

import android.content.Context
import android.util.Log
import com.alangeronimo.data.dto.SakeShopDto
import com.alangeronimo.data.mapper.toDomain
import com.alangeronimo.data.network.SakeShopApi
import com.alangeronimo.data.utils.readBackupJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SakeShopRepositoryImpl(
    private val api: SakeShopApi,
    private val context: Context,
    private val gson: Gson
) : com.alangeronimo.domain.repository.SakeShopRepository {
    override suspend fun getSakeShops(): List<com.alangeronimo.domain.model.SakeShop> {
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
