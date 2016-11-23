Scenario: BrandLandingPage_AC14_1 Authenticated user following a brand and visiting a brand landing page clicks on the unfollow <Brand> button
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
When the user clicks o unfollow brand button for a brand that the user was following
Then the user should see button deselected
And the user shouldn't see brand in MyStyle page