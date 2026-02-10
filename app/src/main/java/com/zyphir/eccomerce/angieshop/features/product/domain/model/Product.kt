package com.zyphir.eccomerce.angieshop.features.product.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Product(
    val id: String,
    val slug: String,
    val name: String,
    val description: String,
    val price: Double,
    val currency: String,
    val imageUrl: String,
    val productImages: List<Banner>
)