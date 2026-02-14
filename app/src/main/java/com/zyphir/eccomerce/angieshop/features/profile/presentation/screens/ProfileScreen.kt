package com.zyphir.eccomerce.angieshop.features.profile.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zyphir.eccomerce.angieshop.features.profile.presentation.components.ProfileAppBar
import com.zyphir.eccomerce.angieshop.features.profile.presentation.views.ProfileView

@Composable
fun ProfileScreen(bottomBar: @Composable (() -> Unit) = {}) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { ProfileAppBar() },
        bottomBar = { bottomBar() }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            ProfileView()
        }
    }
}