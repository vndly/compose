package com.mauriciotogneri.composetest.screens.image.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mauriciotogneri.composetest.base.BaseState

class ImageState(url: String) : BaseState() {
    var url by mutableStateOf(url)
}

class ImageStateFactory(
    private val lifecycle: ViewModelStoreOwner,
    private val url: String,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ImageState(url) as T

    fun get() = ViewModelProvider(lifecycle, this)[ImageState::class.java]
}
