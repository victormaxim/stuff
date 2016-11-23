Scenario: Search_AC5_1 Authenticated user with recent searches navigates the website header, clicks their cursor in the search box and checks the display
Meta:
@open
Given the user authenticates as user with recent searches 
And the user is on 'Homepage' page
When the user clicks on search box 
Then the user should see a dropdown menu with [recent_search]

Examples:
|recent_search|
|<terms of search 1>|
|<terms of search 2>|
|<terms of search n>|

Scenario: Search_AC8_1 Known user with recent searches navigates the website header, clicks their cursor in the search box and checks the display
Meta:
@open
"The dropdown is populated with the following content:
recent searches
<terms of search 1>
<terms of search 2>
...
<terms of search n>"
