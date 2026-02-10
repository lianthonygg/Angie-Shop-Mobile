package com.zyphir.eccomerce.angieshop.features.product.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Banner(
    val id: String,
    val slug: String,
    val imageUrl: String,
)