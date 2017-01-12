Feature: Check weather for a city 
	As a user of weather app
  	I should be able to check weather forecast for a city
  	So that I can get 5 days forecast
  	
Background: App is up and running 
	Given weather app is available 
	
@happyPath @weatherDetails 
Scenario Outline: Verify all mandatory components displayed 
	Given I request weather forecast for Glasgow 
	When I submit the request 
	Then I should get forecast for next 1 days 
	And each days forecast should have <mandatoryComponents> 
	
	Examples: Mandatory detailed weather forecast components - Valid 
		|mandatoryComponents|
		|day				|
		|date				|
		|description		|
		|maximum			|
		|minimum			|
		|speed				|
		|direction			|
		|rainfall			|
		|pressure			|
		
		
@happyPath @smokeTest @forecast 
Scenario Outline: Get 5 day weather forecast 
Given I request weather forecast for <city> 
When I submit the request 
Then I should get forecast for next <noOfDays> days 
			
Examples: List of cities - Valid 
				|city		|noOfDays	|
				|Aberdeen	|5			|
				|Dundee		|5			|
				|Edinburgh	|5			|
				|Glasgow	|5			|
				|Perth		|5			|
				|Stirling	|5			|
				
				
@happyPath @expandSummary @wip
Scenario: Get 3 hourly weather forecast details (All days 8 rows, Except Day 1) 
	Given I request weather forecast for Glasgow 
	When I click and expand the day summary 
	Then correct three hourly details should be displayed for as in app response 
