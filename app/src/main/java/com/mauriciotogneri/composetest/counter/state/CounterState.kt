package com.mauriciotogneri.composetest.counter.state

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mauriciotogneri.composetest.base.BaseState
import com.mauriciotogneri.composetest.counter.model.Counter
import com.mauriciotogneri.composetest.image.activity.ImageActivity

class CounterState(private val context: Context) : BaseState() {
    var counter by mutableStateOf(Counter())

    fun increaseCounter() {
        counter = Counter(counter.value + 1)
    }

    fun openNewScreen() {
        context.startActivity(ImageActivity.intent("https://foo.com/image", context))
    }
}
