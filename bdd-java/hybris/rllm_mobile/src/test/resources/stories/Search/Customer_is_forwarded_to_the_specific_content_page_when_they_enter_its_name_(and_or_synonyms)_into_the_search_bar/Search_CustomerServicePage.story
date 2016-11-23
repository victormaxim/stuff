Scenario: Search_AC19_1 User enters FAQ into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user searches for 'faq'
Then the user should see FAQ customer service page

Scenario: Search_AC20_1 User enters help into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user searches for 'faq'
Then the user should see help customer service page

Scenario: Search_AC21_1 User enters shipping into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user searches for 'shipping'
Then the user should see shipping rules customer service page

Scenario: Search_AC22_1 User enters returns into the search box and submits.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user searches for 'returns'
Then the user should see return policy customer service page
