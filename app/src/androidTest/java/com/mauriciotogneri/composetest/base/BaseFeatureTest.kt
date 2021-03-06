package com.mauriciotogneri.composetest.base

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

typealias GenericTestRule = AndroidComposeTestRule<ActivityScenarioRule<ComponentActivity>, ComponentActivity>

@RunWith(AndroidJUnit4::class)
abstract class BaseFeatureTest<A : ComponentActivity>(
    testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>,
    private val scenario: Scenario
) {
    @get:Rule
    val rule: AndroidComposeTestRule<ActivityScenarioRule<A>, A> = testRule

    @Before
    fun setup() {
        @Suppress("UNCHECKED_CAST")
        Companion.rule = rule as GenericTestRule
    }

    @Test
    fun test() = scenario.steps.invoke()

    companion object Companion {
        lateinit var rule: GenericTestRule

        inline fun <reified A : ComponentActivity> rule(): AndroidComposeTestRule<ActivityScenarioRule<A>, A> =
            createAndroidComposeRule()
    }
}