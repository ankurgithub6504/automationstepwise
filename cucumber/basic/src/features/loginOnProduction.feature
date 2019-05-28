@functional @prod 
Feature: Login to Production 

	In order to perform successful login to production
As a user
I want to enter correct username and password

Background: 
	Given user navigates to google page 
	When user validates the page title 
	
	
Scenario: In order to verify login to google 
	Then user enters "valid" username 
	And user enters "valid" password 
	And user validates the captcha image 
	Then user "should" be successfully logged in 
	
Scenario: In order to verify login to google 
	Then user enters "invalid" username 
	And user enters "invalid" password 
	And user validates the captcha image 
	Then user "shouldnot" be successfully logged in 
	
	
	
