package com.mauriciotogneri.composetest

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mauriciotogneri.composetest.counter.activity.CounterActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest : BaseInstrumentedTest<CounterActivity>() {
    override fun rule() = createAndroidComposeRule<CounterActivity>()

    @Test
    fun test1() {
        val counterSteps = CounterSteps(rule)

        val steps = {
            counterSteps.`I click on the counter`()
            counterSteps.`I see the counter as`(1)
        }
        steps.invoke()
    }
}