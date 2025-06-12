package com.alangeronimo.data.mapper

import com.alangeronimo.data.dto.SakeShopDto
import com.alangeronimo.domain.model.SakeShop

fun SakeShopDto.toDomain(): SakeShop {
    return SakeShop(
        name = name,
        description = description,
        picture = picture,
        rating = rating,
        address = address,
        googleMapsLink = googleMapsLink,
        website = website,
    )
}
