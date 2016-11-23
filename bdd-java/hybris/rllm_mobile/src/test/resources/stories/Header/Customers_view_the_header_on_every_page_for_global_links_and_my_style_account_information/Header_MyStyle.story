Scenario: Header_AC9_1 Unauthenticated user clicks the my style button, clicks any link from the menu, and checks the display
Given the user is on homepage
When the clicks on MyStyle menu
And the user clicks on 'My Style feed' option
Then the user should see Login page

Scenario: Header_AC9_1 Unauthenticated user clicks the my style button, clicks any link from the menu, and authenticates
Given the user is on homepage
And the clicks on MyStyle menu
And the user clicks on 'My Style feed' option
When the user authenticates
Then the user should see My style feed page

Scenario: Header_AC10_1 Authenticated user clicks the my style button and checks the display
Given the user is authenticated as female
And the user is on homepage
When the clicks on MyStyle menu
And the user clicks on 'My Style feed' option
Then the user should see My style feed page
