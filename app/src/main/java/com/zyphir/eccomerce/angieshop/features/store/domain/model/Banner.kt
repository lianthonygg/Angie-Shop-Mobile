package com.zyphir.eccomerce.angieshop.features.store.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Banner(
    val id: String,
    val slug: String,
    val imageUrl: String,
    val category: String,
)
