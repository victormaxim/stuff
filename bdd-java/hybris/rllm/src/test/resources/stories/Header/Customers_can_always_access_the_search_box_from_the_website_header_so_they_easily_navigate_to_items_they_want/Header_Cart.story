Scenario: Header_AC33_1 User clicks the mini cart icon and checks the display
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'Bag link from header'
Then the user should see 'Shopping cart'