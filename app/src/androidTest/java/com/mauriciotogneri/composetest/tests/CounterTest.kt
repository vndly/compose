package com.mauriciotogneri.composetest.tests

import com.mauriciotogneri.composetest.base.BaseFeatureTest
import com.mauriciotogneri.composetest.counter.activity.CounterActivity
import com.mauriciotogneri.composetest.tests.CounterSteps.`I click on the counter`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I click on the image button`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I see the counter as`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I see the image screen`
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*

@RunWith(Parameterized::class)
class CounterTest(locale: Locale) : BaseFeatureTest<CounterActivity>(rule()) {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun locales(): Iterable<Locale> {
            return listOf(Locale("es", "ES"))
        }
    }

    @Test
    fun noClick() = run {
        `I see the counter as`(0)
    }

    @Test
    fun clickOnce() = run {
        `I click on the counter`()
        `I see the counter as`(1)
    }

    @Test
    fun clickTwice() = run {
        `I click on the counter`()
        `I click on the counter`()
        `I see the counter as`(2)
    }

    @Test
    fun openImageScreen() = run {
        `I click on the image button`()
        `I see the image screen`()
    }
}