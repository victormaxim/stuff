Scenario: BrandLandingPage_AC1_1 User navigating the website wants to view a brand or retailer's store page.
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on [page] page
When the user clicks on 'Brand'
Then the user should see 'BrandLanding page'

Examples:
|Brand List Page|
|Direct URL|
|Homepage|
|Header|
|Footer|