package com.mauriciotogneri.composetest.image.state

import android.app.Activity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mauriciotogneri.composetest.base.BaseState

class ImageState(activity: Activity) : BaseState() {
    var url by mutableStateOf(activity.intent.getStringExtra("url")!!)
}
