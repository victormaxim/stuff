Scenario: BrandLandingPage_AC1_1 User navigating the website wants to view a brand or retailer's store page.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the clicks on Brand from [page]
Then the user should see BrandLanding page

Examples:
|Brand List Page|
|Direct URL|
|Homepage|
|Header|
|Footer|