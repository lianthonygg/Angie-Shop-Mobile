package com.zyphir.eccomerce.angieshop.features.product.data.repository

import com.zyphir.eccomerce.angieshop.features.product.data.datasource.ProductDataSource
import com.zyphir.eccomerce.angieshop.features.product.domain.model.ProductBack
import com.zyphir.eccomerce.angieshop.features.product.domain.repository.ProductRepository

class ProductRepositoryImpl(private val dataSource: ProductDataSource): ProductRepository {
    override suspend fun getProduct(slug: String): ProductBack {
        return dataSource.getProduct(slug)
    }
}