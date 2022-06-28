package com.mauriciotogneri.composetest.features

import com.mauriciotogneri.composetest.base.Feature
import com.mauriciotogneri.composetest.base.Scenario
import com.mauriciotogneri.composetest.tests.CounterSteps.`I click on the counter`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I click on the image button`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I see the counter as`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I see the image screen`

val CounterFeature = Feature(
    listOf(
        Scenario {
            `I see the counter as`(0)
        },
        Scenario {
            `I click on the counter`()
            `I see the counter as`(1)
        },
        Scenario {
            `I click on the counter`()
            `I click on the counter`()
            `I see the counter as`(2)
        },
        Scenario {
            `I click on the image button`()
            `I see the image screen`()
        }
    )
)