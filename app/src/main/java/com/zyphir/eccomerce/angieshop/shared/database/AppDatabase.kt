package com.zyphir.eccomerce.angieshop.shared.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zyphir.eccomerce.angieshop.features.cart.domain.dao.CartDao
import com.zyphir.eccomerce.angieshop.features.cart.domain.entities.CartEntity
import com.zyphir.eccomerce.angieshop.features.cart.domain.entities.CartItemEntity

@Database(version = 1, entities = [CartEntity::class, CartItemEntity::class], exportSchema = true)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getCartsDao(): CartDao
}