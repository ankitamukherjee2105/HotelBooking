Feature: Verify Hotel Booking Application

Scenario: Verify Page Heading
	Given I am in the Login page
	And Heading of the Login page is matching
	Then print the heading of the login page 
	
Scenario: Verify username and password error message
	Given I am in the Login page
	And Click on login without username
	And Click on login without password
	Then print the error message and close the browser	

Scenario: Verify redirection of page after clicking on Login button
	Given I am in the Login page
	And Enter the login credentials
	And Getting redirected to Hotel Booking Form
	Then Print the Hotel booking form URL and close the browser	

Scenario: Verify alert box message for the First Name
	Given I am in the Booking form page
	And Click on Confirm button without entering the First Name
	Then Print the alert message displayed for the first name and close the browser

Scenario: Verify the alert box message for Last Name
	Given I am in the Booking form page
	And Click on Confirm button without entering the Last Name
	Then Print the alert message displayed for the Last name and close the browser

Scenario: Verify the alert box message for Email
	Given I am in the Booking form page
	And Click on Confirm button without entering the Email
	And Click on Confirm button by entering the incorrect Email
	Then Print the alert messages for Email and close the browser	
	
Scenario: Verify the alert box message for Mobile
	Given I am in the Booking form page
	And Click on Confirm button without entering Mobile number
	And Click on Confirm by entering incorrect Mobile number
	Then Print the alert messages for Mobile number and close the browser
	
Scenario: Enter the address
	Given I am in the Booking form page
	And Enter address in address field
	Then Print the entered address details in console

Scenario: Verify the alert box message for City
	Given I am in the Booking form page
	And Click on Confirm button without selecting the City
	Then Print the alert message for City and close the browser	
##
Scenario: Verify the alert box message for State
	Given I am in the Booking form page
	And Click on Confirm button without selecting the City
	Then Print the alert message for City and close the browser
	
Scenario: Select the number of people
	Given I am in the Booking form page
	And Select the number of people from dropdown
	Then Print the number of people and number of Rooms and close the browser
	
Scenario: Verify the alert box message for Card holder Name
	Given I am in the Booking form page
	And Click on Confirm button without entering the Card holder Name
	Then Print the alert message for Card holder name and close the browser
	
Scenario: Verify the alert box message for Debit card number
	Given I am in the Booking form page
	And Click on Confirm button without entering the Debit card number
	Then Print the alert message for the Debit card number and close the browser
	
Scenario: Verify the alert box message for CVV
	Given I am in the Booking form page
	And Click on Confirm button without entering CVV
	Then Print the alert message for the CVV and close the browser
	
Scenario: Verify the alert box message for Expiration Month and Year
	Given I am in the Booking form page
	And Click on Confirm button without entering the Expiration Month
	And Click on Confirm button without entering the Expiration Year
	Then Print the alert messages for Expiration Month and Year and close the browser
	##
Scenario: Verify the Booking complete message
	Given I am in the Booking form page
	And Click on Confirm button after entering all the details
	Then User is redirected to success page	
	
	
