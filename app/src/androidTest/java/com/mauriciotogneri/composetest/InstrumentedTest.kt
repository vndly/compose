package com.mauriciotogneri.composetest

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mauriciotogneri.composetest.CounterSteps.`I click on the counter`
import com.mauriciotogneri.composetest.CounterSteps.`I see the counter as`
import com.mauriciotogneri.composetest.counter.activity.CounterActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest : BaseInstrumentedTest() {
    override fun rule() = createAndroidComposeRule<CounterActivity>()

    @Test
    fun test1() = run {
        `I click on the counter`(rule)
        `I see the counter as`(rule, 1)
    }
}