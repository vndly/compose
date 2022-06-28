package com.mauriciotogneri.composetest.base

import android.content.res.Configuration
import android.content.res.Resources
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import java.util.*

typealias GenericTestRule = AndroidComposeTestRule<ActivityScenarioRule<ComponentActivity>, ComponentActivity>

@RunWith(AndroidJUnit4::class)
abstract class BaseFeatureTest<A : ComponentActivity>(
    testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>,
    private val locale: Locale
) {
    @get:Rule
    var rule: AndroidComposeTestRule<ActivityScenarioRule<A>, A> = testRule

    fun run(steps: () -> Unit) = steps.invoke()

    @Before
    fun setup() {
        Locale.setDefault(locale)
        val res: Resources = rule.activity.resources
        val config: Configuration = res.configuration
        config.locale = locale
        res.updateConfiguration(config, res.displayMetrics)

        @Suppress("UNCHECKED_CAST")
        Companion.rule = rule as GenericTestRule
    }

    companion object Companion {
        lateinit var rule: GenericTestRule

        inline fun <reified A : ComponentActivity> rule(): AndroidComposeTestRule<ActivityScenarioRule<A>, A> =
            createAndroidComposeRule()
    }
}