package com.mauriciotogneri.composetest.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mauriciotogneri.composetest.tests.CounterSteps.`I click on the counter`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I click on the image button`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I see the counter as`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I see the image screen`
import com.mauriciotogneri.composetest.base.BaseFeatureTest
import com.mauriciotogneri.composetest.counter.activity.CounterActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterTest : BaseFeatureTest(rule<CounterActivity>()) {
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