Feature: Counter screen

	Scenario: I don't click on the button
		Then I see the counter as 0

	Scenario: I click on the button once
		When I click on the counter
		Then I see the counter as 1

	Scenario: I click on the button twice
		When I click on the counter
		When I click on the counter
		Then I see the counter as 2