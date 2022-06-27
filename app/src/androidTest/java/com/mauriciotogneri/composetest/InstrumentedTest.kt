package com.mauriciotogneri.composetest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.mauriciotogneri.composetest.counter.activity.CounterActivity
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest {
    @get:Rule
    val compose = createComposeRule()

    @Test
    fun openScreen() {
        ActivityScenario.launch(CounterActivity::class.java)

        compose.onNodeWithText("Clicked 0 times").performClick()
        compose.onNodeWithText("Clicked 1 times").assertExists()
    }
}