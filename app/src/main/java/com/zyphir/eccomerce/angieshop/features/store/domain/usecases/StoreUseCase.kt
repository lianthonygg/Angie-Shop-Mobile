package com.zyphir.eccomerce.angieshop.features.store.domain.usecases

import com.zyphir.eccomerce.angieshop.features.store.domain.mappers.ProductMapper
import com.zyphir.eccomerce.angieshop.features.store.domain.model.Product
import com.zyphir.eccomerce.angieshop.features.store.domain.repository.StoreRepository

class StoreUseCase(private val repository: StoreRepository, private val mapper: ProductMapper) {
    suspend fun getAllProducts(): Map<String, List<Product>> {
        val res = repository.getProducts()
        return mapper.mapToResponse(res)
    }
}