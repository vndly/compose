package com.mauriciotogneri.composetest.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mauriciotogneri.composetest.context.AndroidContext

abstract class BaseActivity<S, V> : ComponentActivity() where S : BaseState, V : BaseView {
    lateinit var state: S
    lateinit var view: V

    abstract fun createState(): S

    abstract fun createView(): V

    fun androidContext() : AndroidContext = AndroidContext(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state = createState()
        view = createView()

        setContent {
            view.Root()
        }
    }
}