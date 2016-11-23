Scenario: BrandLandingPage_AC2_1 User navigates the brand list page, homepage, header, footer, or other website page linking to a brand landing page and clicks on the brand or retailers link.
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
Then the user should see [element]

Examples:
|element|
|brand image|
|brand facets and filters|
|brand product grid|
