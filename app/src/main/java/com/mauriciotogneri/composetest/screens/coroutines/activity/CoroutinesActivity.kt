package com.mauriciotogneri.composetest.screens.coroutines.activity

import android.content.Context
import android.content.Intent
import com.mauriciotogneri.composetest.base.BaseActivity
import com.mauriciotogneri.composetest.screens.coroutines.state.CoroutinesState
import com.mauriciotogneri.composetest.screens.coroutines.state.CoroutinesStateFactory
import com.mauriciotogneri.composetest.screens.coroutines.view.CoroutinesView

class CoroutinesActivity : BaseActivity<CoroutinesState, CoroutinesView>() {
    companion object {
        fun intent(context: Context): Intent = Intent(context, CoroutinesActivity::class.java)
    }

    override fun createState() = CoroutinesStateFactory(this).get()

    override fun createView() = CoroutinesView(state)
}