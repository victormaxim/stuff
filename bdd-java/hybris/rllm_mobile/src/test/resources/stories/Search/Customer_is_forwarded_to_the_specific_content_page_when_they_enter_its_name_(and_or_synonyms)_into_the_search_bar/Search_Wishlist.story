Scenario: Search_AC17_1 Authenticated user enters wishlist synonym into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user searches for 'synonym of wishlist'
Then the user should see My Style landing page