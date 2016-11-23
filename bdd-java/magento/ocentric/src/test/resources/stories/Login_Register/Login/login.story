Scenario: User authenticates with valid username and password
Given the user is on homepage
When the user clicks on login link from header
And the user enters 'goodUser@mailinator.com' and 'goodPassword' in the login form
Then the user should see 'Welcome, Silviu Test!' message in header


Scenario: User tries to authenticates but uses wrong username
Given the user is on homepage
When the user clicks on login link from header
And the user enters 'wrongUser@mailinator.com' and 'goodPassword' in the login form
Then the user should see 'Invalid login or password.' error message

Scenario: User tries to authenticates but uses wrong password
Given the user is on homepage
When the user clicks on login link from header
And the user enters 'goodUser@mailinator.com' and 'wrongPassword' in the login form
Then the user should see 'Invalid login or password.' error message