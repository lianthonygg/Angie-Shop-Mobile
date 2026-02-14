package com.zyphir.eccomerce.angieshop.features.store.domain.mappers

import com.zyphir.eccomerce.angieshop.features.store.domain.model.Product
import com.zyphir.eccomerce.angieshop.features.store.domain.model.ProductBack
import com.zyphir.eccomerce.angieshop.features.store.domain.model.StoreUiItem

class ProductMapper {
    fun mapToResponse(data: List<ProductBack>): List<StoreUiItem> {
        return data
            .map { item ->
                Product(
                    id = item.id,
                    slug = item.slug,
                    name = item.name,
                    description = item.description,
                    price = item.price.toInt(),
                    currency = item.currency,
                    category = item.productCategories.first().categories.name,
                    imageUrl = item.imageUrl,
                    isActive = item.isActive
                )
            }
            .groupBy { it.category }
            .flatMap { (category, products) ->
                buildList {
                    add(StoreUiItem.Header(category))
                    products.forEach { product ->
                        add(StoreUiItem.Item(product))
                    }
                }
            }
    }
}