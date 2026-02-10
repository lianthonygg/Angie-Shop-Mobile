package com.zyphir.eccomerce.angieshop.features.product.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BannerBack(
    val id: String,
    val slug: String,
    @SerialName("image_url")
    val imageUrl: String,
)
