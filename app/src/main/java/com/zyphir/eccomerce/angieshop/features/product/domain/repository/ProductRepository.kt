package com.zyphir.eccomerce.angieshop.features.product.domain.repository

import com.zyphir.eccomerce.angieshop.features.product.domain.model.ProductBack

interface ProductRepository {
    suspend fun getProduct(slug: String): ProductBack
}