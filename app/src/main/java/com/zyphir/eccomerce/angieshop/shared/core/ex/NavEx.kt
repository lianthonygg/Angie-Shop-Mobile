package com.zyphir.eccomerce.angieshop.shared.core.ex

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

fun NavBackStack<NavKey>.navigateTo(current: NavKey?, screen: NavKey) {
    if (current == screen) return
    add(screen)
}

fun NavBackStack<NavKey>.back() {
    if (isEmpty()) return
    removeLastOrNull()
}

fun NavBackStack<NavKey>.backTo(targetScreen: NavKey) {
    if (isEmpty()) return
    if (targetScreen !in this) return

    while (isNotEmpty() && last() != targetScreen) {
        removeLastOrNull()
    }
}