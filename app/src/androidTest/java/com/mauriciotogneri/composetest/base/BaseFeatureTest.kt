package com.mauriciotogneri.composetest.base

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseFeatureTest<A : ComponentActivity>(testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>) {
    @get:Rule
    var rule: AndroidComposeTestRule<ActivityScenarioRule<A>, A> = testRule

    init {
        currentRule = rule
    }

    fun run(steps: () -> Unit) = steps.invoke()

    companion object {
        lateinit var currentRule: Any

        @Suppress("UNCHECKED_CAST")
        fun rule() =
            currentRule as AndroidComposeTestRule<ActivityScenarioRule<ComponentActivity>, ComponentActivity>

        inline fun <reified A : ComponentActivity> createRule(): AndroidComposeTestRule<ActivityScenarioRule<A>, A> =
            createAndroidComposeRule()
    }
}