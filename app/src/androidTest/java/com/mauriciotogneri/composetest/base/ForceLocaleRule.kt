package com.mauriciotogneri.composetest.base

import android.content.res.Configuration
import android.content.res.Resources
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.*

class ForceLocaleRule(private val testLocale: Locale) : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                setLocale(testLocale)
                base.evaluate()
            }
        }
    }

    fun setLocale(locale: Locale) {
        val resources: Resources =
            InstrumentationRegistry.getInstrumentation().targetContext.resources
        Locale.setDefault(locale)
        val config: Configuration = resources.configuration
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}