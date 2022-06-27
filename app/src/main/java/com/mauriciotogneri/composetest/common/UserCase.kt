package com.mauriciotogneri.composetest.common

abstract class UserCase<I, O> {
    abstract fun execute(input: I): O
}