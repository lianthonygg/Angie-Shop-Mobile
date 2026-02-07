package com.zyphir.eccomerce.angieshop.shared.state

sealed class UiState<out T> {
    object Waiting : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    data class Error(val message: String) : UiState<Nothing>()
    data class Done<T>(val data: T) : UiState<T>()
}