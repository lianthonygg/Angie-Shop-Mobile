package com.zyphir.eccomerce.angieshop.features.profile.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileAppBar() {
    TopAppBar(
        title = { Text(text = "Perfil") },
    )
}