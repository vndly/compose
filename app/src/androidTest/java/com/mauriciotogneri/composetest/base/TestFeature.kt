@file:Suppress("TestFunctionName")

package com.mauriciotogneri.composetest.base

open class TestFeature(val scenarios: MutableList<TestScenario> = mutableListOf()) {
    fun Scenario(steps: () -> Unit) = TestScenario(steps).also {
        scenarios.add(it)
    }
}

fun Feature(init: TestFeature.() -> Unit): TestFeature = TestFeature().apply { init() }