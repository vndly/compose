package com.mauriciotogneri.composetest.base

import androidx.activity.ComponentActivity

open class BaseActivity<S, V> : ComponentActivity() where S : BaseState, V : BaseView<S> {
    lateinit var state: S
    lateinit var view: V
}