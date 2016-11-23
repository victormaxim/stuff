Scenario: BrandLandingPage_AC7_1 User on brand landing page clicks the narrow dropdown menu and checks the display
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on 'narrow dropdown menu'
Then the user should see 'facets and filters'

Scenario: BrandLandingPage_AC8_1 User on brand landing page clicks the narrow dropdown menu, then clicks it again or closes it, and checks the display
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on 'narrow dropdown menu'
And the user clicks on 'narrow dropdowm menu'
Then the user shouldn't see 'facets and filters'

Scenario: BrandLandingPage_AC9_1 User on brand landing page clicks narrow dropdown menu and selects items to filter the product grid by - one filter
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on 'narrow dropdown menu'
And the user clicks on 'item to filter the product grid'
Then the user should see 'only products that match selected filter'

Scenario: BrandLandingPage_AC9_2 User on brand landing page clicks narrow dropdown menu and selects items to filter the product grid by - multiple filters
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on 'narrow dropdown menu'
And the user clicks on 'multiple filters for the product grid'
Then the user should see 'only products that match selected filters'

Scenario: BrandLandingPage_AC10_1 User on brand landing page clicks narrow dropdown menu and selects items to filter the product grid by and then removes some applied filters - one filter
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on 'narrow dropdown menu'
And the user clicks on 'item to filter the product grid'
And the user clicks on 'remove the filter'
Then the user should see 'all products without filters'

Scenario: BrandLandingPage_AC10_2 User on brand landing page clicks narrow dropdown menu and selects items to filter the product grid by and then removes some applied filters - multiple filters
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on 'narrow dropdown menu'
And the user clicks on 'multiple items to filter the product grid'
And the user clicks on 'remove one filter'
Then the user should see 'only products that match selected filters'
