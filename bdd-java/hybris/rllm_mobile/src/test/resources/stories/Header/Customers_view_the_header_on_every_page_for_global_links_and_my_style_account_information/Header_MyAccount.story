Scenario: Header_AC8_1 Authenticated user navigates to the top of any page of the website and clicks the my account button.
Given the user is authenticated as male
And the user is on homepage
When the user clicks on MyAccount button
Then the user should see My Account - Dashboard page


Scenario: Header_AC8_2 User navigates to the top of any page of the website and clicks the my account button and checks display
Given the user is on homepage
When the user clicks on MyAccount button
Then the user should see Login page

Scenario: Header_AC8_3 User navigates to the top of any page of the website and clicks the my account button and authenticates
Given the user is on homepage
And the user clicks on MyAccount button
When the user authenticates as male
Then the user should see My Account - Dashboard page