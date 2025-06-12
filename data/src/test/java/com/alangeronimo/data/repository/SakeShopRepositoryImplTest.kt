package com.alangeronimo.data.repository


import android.content.Context
import android.content.res.AssetManager
import com.alangeronimo.data.common.MyLogger
import com.alangeronimo.data.dto.SakeShopDto
import com.alangeronimo.data.network.SakeShopApi
import com.alangeronimo.domain.model.SakeShop
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.io.ByteArrayInputStream

class SakeShopRepositoryImplTest {

    private lateinit var repository: SakeShopRepositoryImpl

    @Before
    fun setup() {
        val mockContext = Mockito.mock(Context::class.java)
        val mockAssetManager = Mockito.mock(AssetManager::class.java)
        val dummyJson = """[{"name":"Sake1","description":"desc","picture":null,"rating":4.6,"address":"addr","google_maps_link":"www.googlemaps.com","website":"www.website.com"}]"""

        val stream = ByteArrayInputStream(dummyJson.toByteArray())
        Mockito.`when`(mockAssetManager.open("sake_shops_backup.json")).thenReturn(stream)
        Mockito.`when`(mockContext.assets).thenReturn(mockAssetManager)

        // Repositorio con API fallida y respaldo por JSON
        repository = SakeShopRepositoryImpl(
            api = object : SakeShopApi {
                override suspend fun getSakeShops(): List<SakeShopDto> {
                    throw Exception("Simulated API failure")
                }
            },
            context = mockContext,
            gson = Gson(),
            logger = FakeLogger()
        )
    }

    class FakeLogger : MyLogger {
        override fun logError(tag: String, message: String, throwable: Throwable?) {
            println("[$tag] $message: ${throwable?.message}")
        }
    }

    @Test
    fun `returns backup data when api fails`() = runBlocking {
        val result: List<SakeShop> = repository.getSakeShops()

        assertEquals(1, result.size)
        assertEquals("Sake1", result[0].name)
    }
}

