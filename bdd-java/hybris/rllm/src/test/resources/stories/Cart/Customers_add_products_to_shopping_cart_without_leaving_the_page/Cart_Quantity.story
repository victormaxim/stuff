Scenario: Cart_AC7_1 User edits quantity by choosing a different value via dropdown menu in the cart
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'PDP' page
When the user adds product to cart from PDP
And the user clicks on 'cart icon from header'
And the user selects a different quantity
Then the user should see 'selected quantity'
And the user should see 'cart subtotal and values updated' 
