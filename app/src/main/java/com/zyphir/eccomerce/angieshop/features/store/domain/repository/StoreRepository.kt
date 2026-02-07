package com.zyphir.eccomerce.angieshop.features.store.domain.repository

import com.zyphir.eccomerce.angieshop.features.store.domain.model.ProductBack

interface StoreRepository {
    suspend fun getProducts(): List<ProductBack>;
}