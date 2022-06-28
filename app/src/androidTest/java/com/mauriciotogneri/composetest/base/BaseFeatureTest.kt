package com.mauriciotogneri.composetest.base

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseFeatureTest(testRule: ComposeContentTestRule) {
    @get:Rule
    val rule: ComposeContentTestRule = testRule

    init {
        BaseFeatureTest.rule = rule
    }

    fun run(steps: () -> Unit) = steps.invoke()

    companion object {
        lateinit var rule: ComposeContentTestRule

        inline fun <reified A : ComponentActivity> rule(): ComposeContentTestRule =
            createAndroidComposeRule<A>()
    }
}