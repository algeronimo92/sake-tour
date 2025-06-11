package com.alangeronimo.domain.model

data class SakeShop(
    val name: String,
    val description: String,
    val picture: String?,
    val rating: Float,
    val address: String,
    val googleMapsLink: String,
    val website: String
)
