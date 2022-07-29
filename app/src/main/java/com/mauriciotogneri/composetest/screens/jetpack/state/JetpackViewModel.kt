package com.mauriciotogneri.composetest.screens.jetpack.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class JetpackViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    var param: String by mutableStateOf(savedStateHandle.get<String>("param") ?: "")
}