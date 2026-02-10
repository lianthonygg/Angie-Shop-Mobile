package com.zyphir.eccomerce.angieshop.features.product.data.datasource

import com.zyphir.eccomerce.angieshop.features.product.domain.model.ProductBack
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns

class ProductDataSource(private val supabase: SupabaseClient) {
    suspend fun getProduct(slug: String): ProductBack {
        return supabase
            .from("products")
            .select(
                Columns.raw(
                    "*, product_images(*)"
                )
            ){
                filter {
                    eq("slug", slug)
                }
            }
            .decodeSingle<ProductBack>()
    }
}