Scenario: Homepage_AC18_1 User navigates the homepage and checks a collection that has new products added to it.
Meta:
@waiting
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see 'image block with x new products'

Scenario: Homepage_AC19_1 Female user navigates the homepage and checks the collections carousel
Meta:
@waiting
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'Homepage' page
Then the user should see 'female specific collections'

Scenario: Homepage_AC20_1 Male user navigates the homepage and checks the collections carousel
Meta:
@waiting
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see 'male specific collections'

