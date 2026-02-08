package com.zyphir.eccomerce.angieshop.features.store.domain.model

import androidx.compose.runtime.Immutable
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
    @SerialName("is_active")
    val isActive: Boolean,
    @SerialName("product_categories")
    val productCategories: List<ProductCategory>
)

@Immutable
data class Product(
    val id: String,
    val slug: String,
    val name: String,
    val description: String,
    val price: Double,
    val currency: String,
    val category: String,
    val imageUrl: String,
    val isActive: Boolean,
)
