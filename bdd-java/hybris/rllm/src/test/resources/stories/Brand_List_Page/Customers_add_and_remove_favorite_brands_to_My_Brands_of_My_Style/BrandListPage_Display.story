Scenario: BrandListPage_AC2_1 User navigates brand list page, and checks the default display
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
Then the user should see 'grid with mosaic listing of trending brands and retailers'
And the user should see 'refine button deselected'
And the user should see [component]

Examples:
|component|
|brand image for each brand|
|brand name for each brand|

Scenario: BrandListPage_AC3_1 User navigates brand list page, and clicks the toggle button for list view
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
When the user clicks on 'toggle button for list view'
Then the user should see 'alphabet navigation followed by alphabetical listing of all brands and retailers sold on MP in list view'
