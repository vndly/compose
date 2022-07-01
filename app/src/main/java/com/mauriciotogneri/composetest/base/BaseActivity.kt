package com.mauriciotogneri.composetest.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

abstract class BaseActivity<S : BaseState, V : BaseView> : ComponentActivity() {
    lateinit var state: S
    lateinit var view: V

    abstract fun stateClass(): KClass<S>

    abstract fun createView(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state = ViewModelProvider(this).get(stateClass().java)
        view = createView()

        setContent {
            view.Root()
        }
    }

    override fun onDestroy() {
        view.onDestroy()
        state.onDestroy()

        super.onDestroy()
    }
}