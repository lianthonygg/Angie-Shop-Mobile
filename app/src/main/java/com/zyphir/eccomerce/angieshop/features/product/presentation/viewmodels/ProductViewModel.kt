package com.zyphir.eccomerce.angieshop.features.product.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zyphir.eccomerce.angieshop.features.product.domain.model.Product
import com.zyphir.eccomerce.angieshop.features.product.domain.usecases.ProductUseCase
import com.zyphir.eccomerce.angieshop.shared.state.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductViewModel(private val useCase: ProductUseCase) : ViewModel() {
    private var _product = MutableStateFlow<UiState<Product>>(UiState.Waiting)
    val product: StateFlow<UiState<Product>> = _product

    fun getProduct(slug: String) = viewModelScope.launch {
        _product.value = UiState.Loading

        try {
            val response = withContext(Dispatchers.IO) { useCase.getProduct(slug) }
            _product.value = UiState.Done(response)
        } catch (e: Exception) {
            _product.value = UiState.Error(e.message ?: "Error Desconocido")
        }
    }
}