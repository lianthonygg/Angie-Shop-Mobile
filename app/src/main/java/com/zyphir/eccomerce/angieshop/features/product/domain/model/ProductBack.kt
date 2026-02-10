package com.zyphir.eccomerce.angieshop.features.product.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductBack(
    val id: String,
    val slug: String,
    val name: String,
    val description: String,
    val price: Double,
    val currency: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("product_images")
    val productImages: List<BannerBack>
)
