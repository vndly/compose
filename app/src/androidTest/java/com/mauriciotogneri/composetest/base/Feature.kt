package com.mauriciotogneri.composetest.base

open class Feature(val scenarios: MutableList<Scenario> = mutableListOf()) {
    fun scenario(steps: () -> Unit) = Scenario(steps).also {
        scenarios.add(it)
    }
}

fun feature(init: Feature.() -> Unit): Feature = Feature().apply { init() }