Scenario: Search_AC10_1 User enters product string into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user searches for 'product'
Then the user should see PLP page with products matching entered search term
And the user should see Faceting and Product Grid