Scenario: BrandLandingPage_AC2_1 User navigates the brand list page, homepage, header, footer, or other website page linking to a brand landing page and clicks on the brand or retailers link.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
Then the user should see brand image
And the user should see brand description
And the user should see facets and filters
And the user should see product grid