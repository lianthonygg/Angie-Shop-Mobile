package com.zyphir.eccomerce.angieshop.shared.modules

import com.zyphir.eccomerce.angieshop.features.store.presentation.viewmodels.StoreViewModel
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { StoreViewModel() }
}

val supabaseModule = module {
    single {
        createSupabaseClient(
            supabaseUrl = "",
            supabaseKey = ""
        ) {
            install(Postgrest)
            install(Auth)
            install(Storage)
        }
    }
}