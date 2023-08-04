
Feature: login  
  
	Background:
		Given inter user name and password

	Scenario: find name by user name
		When I submit user name <"ahmad"> and password <"789"> and should enter to admin page
		Then I should be logged in to admin page for username <"ahmad"> and password <"789">

	Scenario: find name by user name
		When I submit user name <"shahad"> and password <"123456"> and should enter to owner page
		Then I should be logged in to owner page

	Scenario: find name by user name
		When I submit user name <"laila"> and password <"123"> and should enter to tenant page
		Then I should be logged in to tenant page
  
