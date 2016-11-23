Scenario: Homepage_AC3_1 Male user navigates the homepage and checks the welcome banner
Meta:
@waiting
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see 'male oriented content'

Scenario: Homepage_AC4_1 Female user navigates the homepage and checks the welcome banner
Meta:
@waiting
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'Homepage' page
Then the user should see 'female oriented content'