package com.zyphir.eccomerce.angieshop.shared.modules

import com.zyphir.eccomerce.angieshop.features.store.data.repository.StoreRepositoryImpl
import com.zyphir.eccomerce.angieshop.features.store.domain.mappers.ProductMapper
import com.zyphir.eccomerce.angieshop.features.store.domain.repository.StoreRepository
import com.zyphir.eccomerce.angieshop.features.store.domain.usecases.StoreUseCase
import com.zyphir.eccomerce.angieshop.features.store.presentation.viewmodels.StoreViewModel
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { StoreViewModel(get()) }
}

val supabaseModule = module {
    single {
        createSupabaseClient(
            supabaseUrl = "https://fanzjptylyuvwvlotopk.supabase.co",
            supabaseKey = "sb_publishable_yV8ez4b2ZAzWoeTsDM98vw_UltbtoTl"
        ) {
            install(Postgrest)
            install(Auth)
            install(Storage)
        }
    }
}

val storeRepositoryModule = module {
    single<StoreRepository> {
        StoreRepositoryImpl(get())
    }
}

val productMapperModule = module {
    single {
        ProductMapper()
    }
}

val storeUseCaseModule = module {
    single {
        StoreUseCase(get(), get())
    }
}