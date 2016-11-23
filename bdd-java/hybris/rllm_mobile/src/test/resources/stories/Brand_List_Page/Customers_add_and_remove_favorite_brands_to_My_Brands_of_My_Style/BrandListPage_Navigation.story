Scenario: BrandListPage_AC1_1 User navigates the website for a list of all brands and retailers sold on MP.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on BrandList page from header
Then the user should see BrandList page
