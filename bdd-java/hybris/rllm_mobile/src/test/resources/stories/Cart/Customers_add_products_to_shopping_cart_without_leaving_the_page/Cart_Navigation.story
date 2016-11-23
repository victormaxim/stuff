Scenario: Cart_AC1_1 User adds products to their cart so they can purchase the items.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user adds product to cart from PDP
And the user clicks on cart icon from header
Then the user should see product in cart
