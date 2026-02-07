package com.zyphir.eccomerce.angieshop.features.store.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zyphir.eccomerce.angieshop.features.store.domain.model.Product
import com.zyphir.eccomerce.angieshop.features.store.domain.usecases.StoreUseCase
import com.zyphir.eccomerce.angieshop.shared.state.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StoreViewModel(private val storeUseCase: StoreUseCase) : ViewModel() {

    private var _products = MutableStateFlow<UiState<Map<String, List<Product>>>>(UiState.Waiting)
    val products: StateFlow<UiState<Map<String, List<Product>>>> = _products

    init {
        getProducts()
    }

    fun getProducts() = viewModelScope.launch {
        _products.value = UiState.Loading

        try {
            val response = withContext(Dispatchers.IO) { storeUseCase.getAllProducts() }
            _products.value = UiState.Done(response)
        } catch (e: Exception) {
            _products.value = UiState.Error(e.message ?: "Error Desconocido")
        }
    }
}