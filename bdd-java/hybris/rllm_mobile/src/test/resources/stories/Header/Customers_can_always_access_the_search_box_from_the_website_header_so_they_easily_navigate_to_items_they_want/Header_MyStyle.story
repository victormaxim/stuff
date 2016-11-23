Scenario: Header_AC10_1 Authenticated user clicks the my style button and checks the display
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'Homepage' page
When the user clicks on MyStyle link
Then the user should see My Style dashboard
