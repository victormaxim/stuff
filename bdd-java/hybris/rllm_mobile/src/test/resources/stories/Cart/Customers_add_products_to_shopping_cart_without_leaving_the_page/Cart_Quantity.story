Scenario: Cart_AC7_1 User clicks the quantity button
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the user adds product to cart from PDP
And the user clicks on cart icon from header
When the user clicks on quantity
Then the user should see dropdown menu with values

Scenario: Cart_AC8_1 User selects new quantity from quantity dropdown menu
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the user adds product to cart from PDP
And the user clicks on cart icon from header
When the user selects a different quantity
Then the user should see selected quantity
And the user should cart subtotal and values updated 
