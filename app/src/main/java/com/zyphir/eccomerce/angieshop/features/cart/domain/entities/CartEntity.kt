package com.zyphir.eccomerce.angieshop.features.cart.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("carts")
data class CartEntity (

    @PrimaryKey
    @ColumnInfo("id")
    val id: String,

    @ColumnInfo("user_id")
    val userId: String,

    @ColumnInfo("created_at")
    val createdAt: String,

    @ColumnInfo("is_active")
    val isActive: Boolean

)