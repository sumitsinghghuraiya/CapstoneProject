@Loginpage
Feature: Login Module
Background:
 Given User on home page and select the "Bhopal" 
 And User on the login page
 
 @Validlogin
 Scenario Outline: Valid login check using mobile and OTP
 When user enter mobile number "<number>"
 And click on continue
 Then Verify OTP page
 And back to login page
 And close page 
 Examples:
| number |
| 7693985574 |

@Invalidlogin
Scenario Outline: Invalid login check using mobile
When user enter invalid mobile "<number>"
Then verify message "<message>"
And close page
Examples:
|number|message|
|45675|Invalid mobile number|

@UIvalidation
Scenario Outline: Verify all login UI elements
When verify that mobile number field is visible
Then verify continue button is not visible
When user enter valid mobile number "<validphone>"
Then Verify continue button should enabled
When user enter invalid mobile number "<invalidphone>"
Then verify continue button is visible but should disable
And close page
Examples:
|invalidphone|validphone|
|898889|7684867565|