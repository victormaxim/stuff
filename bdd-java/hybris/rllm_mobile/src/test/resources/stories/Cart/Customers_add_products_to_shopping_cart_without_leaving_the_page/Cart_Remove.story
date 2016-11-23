Scenario: Cart_AC9_1 User deletes a product from the product list in the cart.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the user adds product to cart from PDP
And the user clicks on cart icon from header
When the user clicks on remove button from cart
Then the user shouldn't see the product in cart
And the subtotal in cart should be updated
