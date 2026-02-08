package com.zyphir.eccomerce.angieshop.features.store.domain.usecases

import com.zyphir.eccomerce.angieshop.features.store.domain.mappers.ProductMapper
import com.zyphir.eccomerce.angieshop.features.store.domain.model.Product
import com.zyphir.eccomerce.angieshop.features.store.domain.model.StoreUiItem
import com.zyphir.eccomerce.angieshop.features.store.domain.repository.StoreRepository

class StoreUseCase(private val repository: StoreRepository, private val mapper: ProductMapper) {
    suspend fun getAllProducts(): List<StoreUiItem> {
        val res = repository.getProducts()
        return mapper.mapToResponse(res)
    }
}