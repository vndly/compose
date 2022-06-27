package com.mauriciotogneri.composetest

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mauriciotogneri.composetest.CounterSteps.`I click on the counter`
import com.mauriciotogneri.composetest.CounterSteps.`I see the counter as`
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest : BaseInstrumentedTest() {
    override fun rule() = rule

    @Test
    fun test1() = run {
        `I click on the counter`()
        `I see the counter as`(1)
    }
}