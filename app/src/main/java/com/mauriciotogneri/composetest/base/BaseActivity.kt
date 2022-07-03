package com.mauriciotogneri.composetest.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import com.mauriciotogneri.composetest.screens.counter.state.EmptyEvent
import com.mauriciotogneri.composetest.screens.counter.state.Event

abstract class BaseActivity<S : BaseState, V : BaseView> : ComponentActivity() {
    lateinit var state: S
    lateinit var view: V

    abstract fun createState(): S

    abstract fun createView(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state = createState()
        view = createView()

        setContent {
            view.Root()
        }
    }

    override fun onDestroy() {
        view.onCleared()

        super.onDestroy()
    }

    fun <T> registerEvent(event: Event<T>, observer: Observer<T>) = event.observe(this, observer)

    fun registerEvent(event: EmptyEvent, observer: () -> Unit) = event.observe(this, { observer() })
}