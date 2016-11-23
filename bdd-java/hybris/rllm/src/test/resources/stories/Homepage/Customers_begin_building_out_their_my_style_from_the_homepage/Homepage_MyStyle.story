Scenario: Homepage_AC19_1 Authenticated or known user navigates the homepage and checks the my style banner
Meta:
@automated
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'Homepage' page
Then the user should see 'My Style banner'

Scenario: Homepage_AC19_2 Authenticated or known user navigates the homepage clicks on banner
Meta:
@waiting
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'Homepage' page
When the user clicks on 'MyStyle banner for authenticated user'
Then the user should see 'My Style page'