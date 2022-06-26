package com.mauriciotogneri.composetest.context

import android.content.Context
import android.content.Intent
import com.mauriciotogneri.composetest.base.BaseContext
import com.mauriciotogneri.composetest.base.ScreenDef

class AndroidContext(private val context: Context) : BaseContext {
    override fun <T : Any> openScreen(screenDef: ScreenDef<T>) {
        val intent = Intent(context, screenDef.screen)

        context.startActivity(intent)
    }
}