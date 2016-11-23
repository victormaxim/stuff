Scenario: BrandLandingPage_AC11_1 Authenticated user on a brand landing page clicks on the follow <Brand> button
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on 'follow brand button'
Then the user should see 'follow button in selected state' 
And the user should see 'brand on MyStyle page'

