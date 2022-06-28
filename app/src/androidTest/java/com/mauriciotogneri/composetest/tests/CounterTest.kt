package com.mauriciotogneri.composetest.tests

import com.mauriciotogneri.composetest.base.BaseFeatureTest
import com.mauriciotogneri.composetest.base.Scenario
import com.mauriciotogneri.composetest.counter.activity.CounterActivity
import com.mauriciotogneri.composetest.features.CounterFeature
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CounterTest(scenario: Scenario) : BaseFeatureTest<CounterActivity>(rule(), scenario) {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun locales(): Iterable<Scenario> = CounterFeature.scenarios
    }
}