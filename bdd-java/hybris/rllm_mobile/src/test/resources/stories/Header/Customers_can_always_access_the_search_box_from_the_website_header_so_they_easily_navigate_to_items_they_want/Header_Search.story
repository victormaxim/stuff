Scenario: Header_AC12_1 User navigates to a nonhomepage page and clicks the search icon
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user navigates to 'Bags' PLP page
And the user clicks on search icon
Then the user should see search box

Scenario: Header_AC13_1 User navigates to a nonhomepage page, clicks the search icon, and clicks it again
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user navigates to 'Bags' PLP page
And the user clicks on search icon
And the user clicks on search icon
Then the user shouldn't see search box

Scenario: Header_AC14_1 User opens the search box and taps to enter search terms
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on search icon
And the user types letter 'a'
Then the user should see types letter
#And the user should see mobile keyboard

Scenario: Header_AC15_1 User taps anywhere outside of the search box or scrolls the page
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on search icon
And the user types letter 'a'
And the user clicks outside the search box
Then the mobile keyboards should dissapear
