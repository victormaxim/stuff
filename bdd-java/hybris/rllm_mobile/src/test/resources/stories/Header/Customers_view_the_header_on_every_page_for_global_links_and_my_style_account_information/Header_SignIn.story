Scenario: Header_AC7_1 Unauthenticated user navigates to the top of any page of the website and clicks the signin button.
Given the user is on homepage
When the user clicks on SignIn link from header
Then the user should see Login page
