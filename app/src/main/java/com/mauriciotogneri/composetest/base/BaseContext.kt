package com.mauriciotogneri.composetest.base

interface BaseContext {
    fun <T : Any> openScreen(screenDef: ScreenDef<T>)
}