Scenario: Homepage_AC5 Female user navigates the homepage and checks the brand carousel
Meta:
@waiting
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'Homepage' page
Then the user should see 'female specific brands'

Scenario: Homepage_AC6 Male user navigates the homepage and checks the brand carousel
Meta:
@waiting
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see 'male specific brands'


Scenario: Homepage_AC7 User navigates the homepage and checks a brand that has new products added to it.
Meta:
@waiting
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see 'brand with new product'

Scenario: Homepage_AC8 User navigates the homepage and clicks on a brand.
Meta:
@waiting
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'brand image'
Then the user should see 'Brand Landing Page'
