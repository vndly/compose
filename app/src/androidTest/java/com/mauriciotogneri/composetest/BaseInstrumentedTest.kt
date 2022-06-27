package com.mauriciotogneri.composetest

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseInstrumentedTest {
    @get:Rule
    val rule: ComposeContentTestRule by lazy { rule() }

    abstract fun rule(): ComposeContentTestRule

    fun run(steps: () -> Unit) = steps.invoke()
}