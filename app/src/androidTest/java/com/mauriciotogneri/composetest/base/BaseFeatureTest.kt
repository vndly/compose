package com.mauriciotogneri.composetest.base

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseFeatureTest<A : ComponentActivity>(testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>) {
    @get:Rule
    val rule: AndroidComposeTestRule<ActivityScenarioRule<A>, A> = testRule

    init {
        BaseFeatureTest.rule = rule
    }

    fun run(steps: () -> Unit) = steps.invoke()

    companion object {
        lateinit var rule: ComposeContentTestRule

        @Suppress("UNCHECKED_CAST")
        fun <A : ComponentActivity> getRule(): AndroidComposeTestRule<ActivityScenarioRule<A>, A> =
            rule as AndroidComposeTestRule<ActivityScenarioRule<A>, A>

        inline fun <reified A : ComponentActivity> rule(): AndroidComposeTestRule<ActivityScenarioRule<A>, A> =
            createAndroidComposeRule()
    }
}