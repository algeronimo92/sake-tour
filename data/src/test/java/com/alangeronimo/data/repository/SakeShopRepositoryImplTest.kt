package com.alangeronimo.data.repository

import android.content.Context
import android.content.res.AssetManager
import com.alangeronimo.data.common.MyLogger
import com.alangeronimo.data.dto.SakeShopDto
import com.alangeronimo.data.network.SakeShopApi
import com.alangeronimo.domain.model.SakeShop
import com.google.gson.Gson
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import java.io.ByteArrayInputStream
import kotlin.test.assertTrue

class SakeShopRepositoryImplTest {

    private lateinit var repository: SakeShopRepositoryImpl

    private fun getMockContext(): Context {
        val dummyJson =
            """[{"name":"Sake1","description":"desc","picture":null,"rating":4.6,"address":"my_address","google_maps_link":"www.google_maps.com","website":"www.website.com"}]"""
        val mockContext = Mockito.mock(Context::class.java)
        val mockAssetManager = Mockito.mock(AssetManager::class.java)
        `when`(mockContext.assets).thenReturn(mockAssetManager)
        val stream = ByteArrayInputStream(dummyJson.toByteArray())
        `when`(mockAssetManager.open("sake_shops_backup.json")).thenReturn(stream)
        return mockContext
    }


    private class FakeLogger : MyLogger {
        val logs = mutableListOf<String>()
        override fun logError(tag: String, message: String, throwable: Throwable?) {
            logs.add("[$tag] $message")
        }
    }

    @Test
    fun `returns backup data when api fails`() = runTest {
        //given
        repository = SakeShopRepositoryImpl(
            api = object : SakeShopApi {
                override suspend fun getSakeShops(): List<SakeShopDto> {
                    throw Exception("Simulated API failure")
                }
            }, context = getMockContext(), gson = Gson(), logger = FakeLogger()
        )
        //when
        val result: List<SakeShop> = repository.getSakeShops()
        //then
        assertEquals(1, result.size)
        assertEquals("Sake1", result[0].name)
    }


    @Test
    fun `throws when backup JSON is invalid`() = runTest {
        //given
        val logger = FakeLogger()
        val repo = SakeShopRepositoryImpl(
            api = object : SakeShopApi {
                override suspend fun getSakeShops(): List<SakeShopDto> {
                    throw RuntimeException("Simulated failure")
                }
            }, context = getMockContext(), gson = Gson(), logger = logger
        )
        //when
        repo.getSakeShops()
        //then
        assertTrue(logger.logs.any { it.contains("Loading fallback") })
    }
}
