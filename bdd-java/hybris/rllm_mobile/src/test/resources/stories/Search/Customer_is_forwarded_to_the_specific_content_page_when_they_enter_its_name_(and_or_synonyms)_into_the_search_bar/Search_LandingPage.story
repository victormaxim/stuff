Scenario: Search_AC11_1 User enters an existing brand name into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user searches for 'brand name'
Then the user should see Brand Landing Page for that brand

Scenario: Search_AC12_1 User enters an existing collection name into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user searches for 'collection name'
Then the user should see PLP page for that collection
And the user should see Faceting and product grid

Scenario: Search_AC13_1 User enters gift cards into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user searches for 'gift cards'
Then the user should see Gift Cards landing page

Scenario: Search_AC14_1 User enters a synonym for gift card into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user searches for 'synonym for gift cards'
Then the user should see Gift Cards landing page

Scenario: Search_AC15_1 Authenticated user enters wishlist into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
When the user searches for 'wishlist'
Then the user should see My Style landing page