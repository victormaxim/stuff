Scenario: Homepage_AC30_1 Authenticated or known user navigates the homepage and checks the my style banner - display
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see 'My Style banner'

Scenario: Homepage_AC30_2 Authenticated or known user navigates the homepage and checks the my style banner - click on banner
Meta:
@waiting
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'My Style banner'
Then the user should see 'My Style page'
