package com.mauriciotogneri.myapplication

import com.mauriciotogneri.composetest.screens.coroutines.state.CoroutinesState
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun testSuspendFunction() {
        runBlocking {
            val state = CoroutinesState()
            val greetings = state.greetings()
            assertEquals("Hello, world!", greetings)
        }
    }
}