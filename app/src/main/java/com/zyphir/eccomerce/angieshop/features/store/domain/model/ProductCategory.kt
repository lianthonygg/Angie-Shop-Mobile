package com.zyphir.eccomerce.angieshop.features.store.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductCategory(
    val categories: Category
)

@Serializable
data class Category (
    val id: String,
    val name: String,
    val slug: String,
    @SerialName("is_active")
    val isActive: Boolean
)