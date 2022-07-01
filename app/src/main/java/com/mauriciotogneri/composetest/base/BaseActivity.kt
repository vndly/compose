package com.mauriciotogneri.composetest.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

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
        view.onDestroy()
        state.onDestroy()

        super.onDestroy()
    }
}