package com.zyphir.eccomerce.angieshop.features.store.domain.mappers

import com.zyphir.eccomerce.angieshop.features.store.domain.model.Product
import com.zyphir.eccomerce.angieshop.features.store.domain.model.ProductBack

class ProductMapper {
    fun mapToResponse(data: List<ProductBack>): Map<String, List<Product>> {
        val products = mutableListOf<Product>()

        data.forEach { item ->
            products.add(Product(
                id = item.id,
                slug = item.slug,
                name = item.name,
                description = item.description,
                price = item.price,
                currency = item.currency,
                category = item.productCategories[0].categories.name,
                imageUrl = item.imageUrl,
                isActive = item.isActive
            ))
        }

        val productsForCategory = products.groupBy { it.category }

        return productsForCategory
    }
}