Scenario: Cart_AC8_1 User deletes a product from the product list in the cart.
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'PDP' page
When the user clicks on 'add to to cart from PDP'
And the user clicks on 'cart icon from header'
And the user clicks on 'remove button from cart'
Then the user shouldn't see 'the product in cart'
And the user should see 'subtotal in cart should be updated'
