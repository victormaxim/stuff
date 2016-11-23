Scenario: Homepage_AC2_2 Authenticated user navigates to homepage and checks display
Meta:
@blocked
@issue RUE-832
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see 'Welcome banner'
And the user should see 'Men category banner link'
And the user should see 'Womens category banner link'
And the user should see 'Kids category banner link'
And the user should see 'Brand banner link'
And the user should see 'Collection banner link'
And the user should see 'My Style feed'