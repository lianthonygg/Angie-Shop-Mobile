package com.zyphir.eccomerce.angieshop.features.product.domain.usecases

import com.zyphir.eccomerce.angieshop.features.product.domain.mappers.ProductMapper
import com.zyphir.eccomerce.angieshop.features.product.domain.model.Product
import com.zyphir.eccomerce.angieshop.features.product.domain.repository.ProductRepository

class ProductUseCase(private val repository: ProductRepository, private val mapper: ProductMapper) {
    suspend fun getProduct(slug: String): Product {
        val product = repository.getProduct(slug)
        return mapper.mapToResponse(product)
    }
}