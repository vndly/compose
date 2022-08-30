package com.mauriciotogneri.composetest.screens.image.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mauriciotogneri.composetest.base.BaseState

class ImageState(url: String) : BaseState() {
    var url: String by mutableStateOf(url)
}