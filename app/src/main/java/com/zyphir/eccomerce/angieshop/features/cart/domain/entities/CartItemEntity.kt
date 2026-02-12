package com.zyphir.eccomerce.angieshop.features.cart.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "cart_items",
    foreignKeys = [
        ForeignKey(
            entity = CartEntity::class,
            parentColumns = ["id"],
            childColumns = ["cart_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("cart_id")
    ]
)
data class CartItemEntity (

    @PrimaryKey
    @ColumnInfo("id")
    val id: String,

    @ColumnInfo("cart_id")
    val cartId: String,

    @ColumnInfo("product_id")
    val productId: String,

    @ColumnInfo("quantity")
    val quantity: String,

    @ColumnInfo("created_at")
    val createdAt: String,

    @ColumnInfo("is_active")
    val isActive: Boolean

)