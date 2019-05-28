@sanity 
Feature: Login 

	In order to perform successful login
As a user
I want to enter correct username and password

Scenario Outline: In order to verify login to google 
	Given user navigates to google page 
	When user validates the page title 
	Then user enters "<username> " username 
	And user enters "<password>" password 
	And user selects the age category 
		| Age | Location |
		| below 18 | India |
		| above 18 | USA |
	Then user "<loginType>" be successfully logged in 
	
	Examples: 
		| username | password | loginType |
		| valid	| valid	   | should	   |
		| invalid 	| invalid  | shouldnot |
		
		
