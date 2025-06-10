package com.alangeronimo.saketour.data.dto

import com.alangeronimo.saketour.domain.model.SakeShop
import com.google.gson.annotations.SerializedName

data class SakeShopDto(
    val name: String,
    val description: String,
    val picture: String?,
    val rating: Float,
    val address: String,
    @SerializedName("google_maps_link") val googleMapsLink: String,
    val website: String
) {
    fun toDomain() = SakeShop(
        name = name,
        description = description,
        picture = picture,
        rating = rating,
        address = address,
        googleMapsLink = googleMapsLink,
        website = website
    )
}
