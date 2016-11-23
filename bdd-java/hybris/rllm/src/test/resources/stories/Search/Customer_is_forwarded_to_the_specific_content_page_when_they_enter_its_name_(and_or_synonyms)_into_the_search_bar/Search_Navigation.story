Scenario: Search_AC1_1 User navigates the website to enter their terms of search.
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on [page] page
Then the user should see 'search box'

Examples:
|page|
|homepage|
|PLP|
|Brand|
|GiftCard|
|PDP|