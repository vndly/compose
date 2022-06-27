package com.mauriciotogneri.composetest

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mauriciotogneri.composetest.CounterSteps.`I click on the counter`
import com.mauriciotogneri.composetest.CounterSteps.`I see the counter as`
import com.mauriciotogneri.composetest.Ruler.rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest : BaseInstrumentedTest(rule) {
    @Test
    fun noClick() = run {
        `I see the counter as`(0)
    }

    @Test
    fun clickOnce() = run {
        `I click on the counter`()
        `I see the counter as`(1)
    }

    /*@Test
    fun clickTwice() = run {
        `I click on the counter`()
        `I click on the counter`()
        `I see the counter as`(2)
    }*/
}