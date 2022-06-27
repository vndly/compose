package com.mauriciotogneri.composetest

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseInstrumentedTest(testRule: ComposeContentTestRule) {
    @get:Rule
    val rule: ComposeContentTestRule = testRule

    fun run(steps: () -> Unit) = steps.invoke()
}