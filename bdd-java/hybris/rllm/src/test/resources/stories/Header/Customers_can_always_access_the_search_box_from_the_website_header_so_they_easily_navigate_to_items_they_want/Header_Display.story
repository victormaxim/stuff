Scenario: Header_AC20_1 Authenticated user clicks the My Account button and checks the display
Meta:
@automated
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'Homepage' page
When the user hovers over 'My Account menu'
Then the user should see 'Account Info'
And the user should see 'Member Info'
And the user should see 'Stored Addresses'
And the user should see 'Stored Credit Cards'
And the user should see 'Order History'
And the user should see 'My Returns'
And the user should see 'My Credit'
And the user should see 'Notification Settings'
And the user should see 'Logout link'

Scenario: Header_AC31_1 Authenticated user clicks the my style button and checks the display
Meta:
@automated
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'Homepage' page
When the user hovers over 'My Style menu'
Then the user should see 'My Style Feed'
And the user should see 'My Products'
And the user should see 'My Brands'
And the user should see 'My Collections'
And the user should see 'My Sizes'
And the user should see 'My Searches'

Scenario: Header_AC34_1 User navigates the header and checks the top level navigation display
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see 'Women top level category'
Then the user should see 'Men top level category'
Then the user should see 'Kids top level category'
Then the user should see 'Brands top level category'
Then the user should see 'Collections top level category'

Scenario: Header_AC32_1 Authenticated user clicks the my style button, clicks any link from the menu, and checks the display
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user hovers over 'My Style menu'
And the user clicks on 'My Products from My Style menu'
Then the user should see 'My Products page'
