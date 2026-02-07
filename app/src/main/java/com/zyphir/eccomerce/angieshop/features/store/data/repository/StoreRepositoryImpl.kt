package com.zyphir.eccomerce.angieshop.features.store.data.repository

import com.zyphir.eccomerce.angieshop.features.store.domain.model.ProductBack
import com.zyphir.eccomerce.angieshop.features.store.domain.repository.StoreRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.Order

class StoreRepositoryImpl(private val supabase: SupabaseClient) : StoreRepository {
    override suspend fun getProducts(): List<ProductBack> {
        return supabase
            .from("products")
            .select(
                Columns.raw(
                    """
                    id,
                    slug,
                    name,
                    description,
                    price,
                    currency,
                    image_url,
                    is_active,
                    sort_order,
                    product_categories!inner(categories(*))
                    """
                )
            ) {
                filter {
                    eq("is_active", true)
                }
                order("sort_order", Order.ASCENDING)
            }
            .decodeList<ProductBack>()
    }
}