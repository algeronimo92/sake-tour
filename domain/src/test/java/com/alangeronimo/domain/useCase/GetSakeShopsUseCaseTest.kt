package com.alangeronimo.domain.useCase

import kotlinx.coroutines.runBlocking
import com.alangeronimo.domain.model.SakeShop
import com.alangeronimo.domain.repository.SakeShopRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetSakeShopsUseCaseTest {

    private lateinit var useCase: GetSakeShopsUseCase

    private val fakeRepository = object : SakeShopRepository {
        override suspend fun getSakeShops(): List<SakeShop> {
            return listOf(
                SakeShop(
                    name = "Fake Sake",
                    description = "Test sake shop",
                    picture = null,
                    rating = 4.5f,
                    address = "123 Test St",
                    googleMapsLink = "www.googlemaps.com",
                    website = "www.mywebsite.com"
                )
            )
        }
    }

    @Before
    fun setup() {
        useCase = GetSakeShopsUseCase(fakeRepository)
    }

    @Test
    fun `returns sake shop list`() = runBlocking {
        //given

        //when
        val result = useCase()
        //then
        assertEquals(1, result.size)
        assertEquals("Fake Sake", result[0].name)
        assertEquals("Test sake shop", result[0].description)
        assertEquals(null, result[0].picture)
        assertEquals(4.5f, result[0].rating)
        assertEquals("123 Test St", result[0].address)
        assertEquals("www.googlemaps.com", result[0].googleMapsLink)
        assertEquals("www.mywebsite.com", result[0].website)
    }

}