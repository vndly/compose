package com.mauriciotogneri.composetest.counter.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mauriciotogneri.composetest.base.BaseContext
import com.mauriciotogneri.composetest.base.BaseState
import com.mauriciotogneri.composetest.counter.model.Counter
import com.mauriciotogneri.composetest.image.activity.ImageActivity

class CounterState(private val context: BaseContext) : BaseState() {
    var counter by mutableStateOf(Counter())

    fun increaseCounter() {
        counter = Counter(counter.value + 1)
    }

    fun openNewScreen() {
        context.openScreen(ImageActivity.def("https://foo.com/image"))
    }
}
