package com.zyphir.eccomerce.angieshop.features.cart.domain.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CartDao {
    @Query("SELECT * FROM carts WHERE user_id = :userId AND is_active = 1")
    suspend fun getCart(userId: String)

    @Query("SELECT * FROM cart_items WHERE cart_id = :cartId AND is_active = 1")
    suspend fun getCartItems(cartId: String)
}