package com.mauriciotogneri.composetest

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mauriciotogneri.composetest.counter.activity.CounterActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest : BaseInstrumentedTest<CounterActivity>() {
    override fun rule() = createAndroidComposeRule<CounterActivity>()

    @Test
    fun openScreen1() {
        compose.onNodeWithText("Clicked 0 times").performClick()
        compose.onNodeWithText("Clicked 1 times").assertExists()
    }

    @Test
    fun openScreen2() {
        compose.onNodeWithText("Clicked 0 times").performClick()
        compose.onNodeWithText("Clicked 1 times").performClick()
        compose.onNodeWithText("Clicked 2 times").assertExists()
    }
}