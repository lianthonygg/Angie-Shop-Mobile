package com.zyphir.eccomerce.angieshop.features.product.di

import com.zyphir.eccomerce.angieshop.features.product.data.datasource.ProductDataSource
import com.zyphir.eccomerce.angieshop.features.product.data.repository.ProductRepositoryImpl
import com.zyphir.eccomerce.angieshop.features.product.domain.repository.ProductRepository
import com.zyphir.eccomerce.angieshop.features.product.domain.usecases.ProductUseCase
import com.zyphir.eccomerce.angieshop.features.product.presentation.viewmodels.ProductViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val productModule = module {
    single {
        ProductDataSource(get())
    }

    single<ProductRepository> {
        ProductRepositoryImpl(get())
    }

    single {
        ProductUseCase(get(), get())
    }

    viewModel { ProductViewModel(get()) }
}