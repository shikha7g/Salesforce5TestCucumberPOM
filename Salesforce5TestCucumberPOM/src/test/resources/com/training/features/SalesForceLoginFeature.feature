

Feature: Login to the Salesforce application
 
Background: 
	Given user go to url "https://login.salesforce.com"
	
	@EmptyPassword
  Scenario: Login with empty password
    When user on "LoginPage"
    When user enters "pooja@tekarch.com" in username field
    And user clears password in password field
    And user clicks on login button
    Then validate error msg is displayed as "Please enter your password."

@ValidLogin
Scenario: Login with correct username and password
		When user on "LoginPage"
		When user enters "pooja@tekarch.com" in username field
    And user enters "Home@123"  in password field
    And user clicks on login button
    Then user on "HomePage"
    And validate page title should be "Home Page ~ Salesforce - Developer Edition"
  
  @RememberMe  
  Scenario: remember username when remember checkbox is selected
   	When user on "LoginPage"
		When user enters "pooja@tekarch.com" in username field
    And user enters "Home@123"  in password field
    And user clicks on Remember me checkbox
     And user clicks on login button
    Then user on "HomePage"
     And validate page title should be "Home Page ~ Salesforce - Developer Edition"
     Then click on user menu drop down
     And user selects Logout link
     Then user on "LoginPage"
     And validate username should be "pooja@tekarch.com"
 
 @ForgotPassword    
 Scenario: Forgot Password
 		When user on "LoginPage"
 			When user clicks on Forgot Password
 			Then user on "ForgotPassword"
 			Then verify page title as "Forgot Your Password | Salesforce"
 			And user enters "pooja@tekarch.com" in username
 			And user click on continue button and message displayed is "We’ve sent you an email with a link to finish resetting your password."
 	
 	@InvalidCredentials		
 Scenario: Wrong username and password
 		When user on "LoginPage"
		When user enters "123" in username field
    And user enters "22131"  in password field
    And user clicks on login button
 		Then validate error msg displayed as "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";