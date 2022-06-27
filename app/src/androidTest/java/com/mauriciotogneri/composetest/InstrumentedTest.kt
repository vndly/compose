package com.mauriciotogneri.composetest

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.mauriciotogneri.composetest.counter.activity.CounterActivity
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.mauriciotogneri.composetest", appContext.packageName)
    }

    @Test
    fun openScreen() {
        ActivityScenario.launch(CounterActivity::class.java)

        //composeTestRule.onNode().performClick()
    }
}