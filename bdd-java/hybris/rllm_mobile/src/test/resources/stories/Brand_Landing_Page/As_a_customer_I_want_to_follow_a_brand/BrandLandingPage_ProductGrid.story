Scenario: BrandLandingPage_AC3_1 User navigates to a brand landing page and clicks on a product image or title link - product image
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on product image
Then the user should see PDP page for that product

Scenario: BrandLandingPage_AC3_2 User navigates to a brand landing page and clicks on a product image or title link - title link
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
When the user clicks on product title link
Then the user should see PDP page for that product

Scenario: BrandLandingPage_AC4_1 Authenticated/known user navigates to a brand landing page and clicks on an add to my style icon
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on BrandLanding page
When the user clicks on add to my style icon
Then the user should see icon in selected state 
And the user should see product in MyStyle

Scenario: BrandLandingPage_AC6_1 Authenticated/known user navigates to a brand landing page and clicks on a my style icon for a product that they favorited.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on BrandLanding page
When the clicks on my style icon for a product that they favorited
Then the user should see icon in disabled state
And the user shouldn't see product in MyStyle page
