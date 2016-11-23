
Scenario: BrandListPage_AC12_1 User navigates brand list page, and clicks the refine brands button and selects men filter option
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
When the user clicks on refine brands button
And the user selects men filter option
Then the user should see all trending mens brands

Scenario: BrandListPage_AC13_1 User navigates brand list page, and clicks the refine brands button and selects women filter option
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
When the user clicks on refine brands button
And the user selects women filter option
Then the user should see all trending women brands


Scenario: BrandListPage_AC14_1 User navigates brand list page, and clicks the refine brands button and selects kids filter option
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
When the user clicks on refine brands button
And the user selects kids filter option
Then the user should see all trending kids brands

Scenario: BrandListPage_AC15_1 User navigates brand list page, and clicks the refine brands button and selects A-Z sort option
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
When the user clicks on refine brands button
And the user selects AZ sort option
Then the user should see all brands in alphabetical order
And the user should see anchor navigation

Scenario: BrandListPage_AC16_1 User navigates brand list page, and clicks the refine brands button and selects A-Z sort option and men filter
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
When the user clicks on refine brands button
And the user selects men filter option
And the user selects AZ sort option
Then the user should see all trending mens brands in alphabetical order
And the user should see anchor navigation

Scenario: BrandListPage_AC17_1 User navigates brand list page, and clicks the refine brands button and selects A-Z sort option and women filter
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
When the user clicks on refine brands button
And the user selects women filter option
And the user selects AZ sort option
Then the user should see all trending women brands in alphabetical order
And the user should see anchor navigation

Scenario: BrandListPage_AC18_1 User navigates brand list page, and clicks the refine brands button and selects A-Z sort option and kids filter
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
When the user clicks on refine brands button
And the user selects kids filter option
And the user selects AZ sort option
Then the user should see all trending kids brands in alphabetical order
And the user should see anchor navigation

Scenario: BrandListPage_AC29_1 User navigates brand list page and selects the A-Z view option and clicks a letter (or number sign)
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
And the user clicks on refine brands button
And the user selects AZ sort option
When the user clicks on letter from A-Z view
Then the user should see section corresponding to selected letter
