package com.alangeronimo.data.mapper

import com.alangeronimo.data.dto.SakeShopDto
import org.junit.Test
import kotlin.test.assertEquals

class SakeShopMapperTest {
    @Test
    fun `SakeShopDto should correctly map to domain SakeShop`() {
        val dto =
            SakeShopDto(
                name = "Sake One",
                description = "Fine and smooth",
                picture = "https://example.com/sake.png",
                rating = 4.8f,
                address = "456 Nihonbashi, Tokyo",
                googleMapsLink = "https://maps.google.com/sakeone",
                website = "https://sakeone.jp",
            )

        val domain = dto.toDomain()

        assertEquals("Sake One", domain.name)
        assertEquals("Fine and smooth", domain.description)
        assertEquals("https://example.com/sake.png", domain.picture)
        assertEquals(4.8f, domain.rating)
        assertEquals("456 Nihonbashi, Tokyo", domain.address)
        assertEquals("https://maps.google.com/sakeone", domain.googleMapsLink)
        assertEquals("https://sakeone.jp", domain.website)
    }
}
