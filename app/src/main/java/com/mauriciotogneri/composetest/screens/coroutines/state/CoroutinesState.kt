package com.mauriciotogneri.composetest.screens.coroutines.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mauriciotogneri.composetest.base.BaseState

class CoroutinesState() : BaseState() {
    fun test1() {}
}

class CoroutinesStateFactory(
    private val lifecycle: ViewModelStoreOwner,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = CoroutinesState() as T

    fun get() = ViewModelProvider(lifecycle, this).get(CoroutinesState::class.java)
}
