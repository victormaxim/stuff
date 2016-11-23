Scenario: BrandLandingPage_AC1m_1 User on brand landing page clicks the narrow dropdown menu and checks the display
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on narrow dropdown menu
Then the user should see modal windows with available facets and filters

Scenario: BrandLandingPage_AC2m_1 User on brand landing page clicks the categories dropdown menu and checks the display
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on categories dropdown menu
Then the user should see a modal window with corresponding facets and filters

Scenario: BrandLandingPage_AC3m_1 User on brand landing page clicks the sort dropdown menu and checks the display
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on sort dropdown menu
Then the user should see modal window with corresponding facets and filters

Scenario: BrandLandingPage_AC4m_1 User on brand landing page clicks the narrow dropdown menu, then clicks the x to close, and checks the display
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
And the user clicks on narrow dropdown menu
When the user clicks on x button
Then the user shouldn't see 'facets and filters modal window'
And the user should see 'BrandLanding page elements'

Scenario: BrandLandingPage_AC5m_1 User on brand landing page clicks narrow dropdown menu and selects items to filter the product grid by and clicks apply.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the clicks on narrow dropdown menu
And the user selects item to filter
Then the user should see only products of the brand that match the selected filters

Scenario: BrandLandingPage_AC6m_1 User on brand landing page clicks narrow dropdown menu and selects items to filter the product grid by and then removes some applied filters.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
And the user clicks on narrow dropdown menu
And the user selects item to filter
When the user removes the applied filter
Then the user should all products from that brand
