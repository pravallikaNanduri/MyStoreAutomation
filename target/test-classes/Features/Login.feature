@Login-page
Feature: Login to My Store page

	@New-User
  Scenario: Login Functionality for a User
		Given user navigates to the website <URL> and clicks sign in
			|http://automationpractice.com/index.php|
		When the New user logs in using valid Email address as <email>
			|Tester.5@gmail.com|
		And the user clicks Create an account button
		When user should be redirected to create account page and enters details
		|title|firstName|lastName|password|dob|address|city|state|zipCode|mobile|alias|
		|Mr|King|Kong|1234?|11-03-2016|lakeview|kansas city|kansas|91983|963258741|Home|
		And clicks Register
		Then user should be redirected to home page
		
	@New-user-invalid
	Scenario: Login Functionality for a User
		Given user navigates to the website <URL> and clicks sign in
			|http://automationpractice.com/index.php|Chrome|
		When the New user logs in using invalid Email address as <email>
			|Tester.1@email|
			|Tester.com|
			||
		And the user clicks Create an account button
		Then error must be displayed
		
	@New-user-invalid
	Scenario: Login Functionality for a User
		Given user navigates to the website <URL> and clicks sign in
			|http://automationpractice.com/index.php|Chrome|
		When the New user logs in using invalid Email address as <email>
			|Tester.1@email|
		And the user clicks Create an account button
		Then error must be displayed
		
	@existing-user
	Scenario: Login Functionality for a User
		Given user navigates to the website <URL> and clicks sign in
			|http://automationpractice.com/index.php|Chrome|
		When there Existing user logs in using Email address as <email> and Password as <password>
			|email| password|
	    |Tester.4@gmail.com|1234?|
	  And the user clicks Sign in button
		Then login must be successful.
		
	@existing-user-invalid
	Scenario: Login Functionality for a User
		Given user navigates to the website <URL> and clicks sign in
			|http://automationpractice.com/index.php|Chrome|
		When the Existing user logs in using invalid Email address as <email> and invalid Password as <password>
      |Tester.2@gmail.com|invalid|
      |Tester.3@email.com| |
      ||1234|
      | | |
		Then login must be unsuccessful an appropriate error should be dispayed.
		
	@forgot-password
	Scenario: Login Functionality for a User
		Given user navigates to the website <URL> and clicks sign in
			|http://automationpractice.com/index.php|Chrome|
		When the Existing user logs in using valid Email address as <email>
      |Tester.4@gmail.com|
    And clicks forgot password
		Then user should be redirected to forgot you password page
      