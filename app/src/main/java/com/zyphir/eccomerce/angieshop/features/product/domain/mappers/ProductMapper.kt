package com.zyphir.eccomerce.angieshop.features.product.domain.mappers

import com.zyphir.eccomerce.angieshop.features.product.domain.model.Banner
import com.zyphir.eccomerce.angieshop.features.product.domain.model.Product
import com.zyphir.eccomerce.angieshop.features.product.domain.model.ProductBack

class ProductMapper {
    fun mapToResponse(data: ProductBack): Product {
        return Product(
            id = data.id,
            slug = data.slug,
            name = data.name,
            description = data.description,
            price = data.price,
            currency = data.currency,
            imageUrl = data.imageUrl,
            productImages = data.productImages.map { item ->
                Banner(
                    id = item.id,
                    slug = item.slug,
                    imageUrl = item.imageUrl
                )
            }
        )
    }
}