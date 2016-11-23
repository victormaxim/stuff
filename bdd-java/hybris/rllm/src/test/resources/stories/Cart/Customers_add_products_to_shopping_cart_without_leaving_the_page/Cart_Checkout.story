Scenario: Cart_AC4_1 Authenticated user with no saved shipping or payment information clicks checkout button
Meta:
@open
Given the user is authenticated as user without saved shipping or payment information
When the user adds product to cart from PDP page
And the user clicks on 'cart icon from header'
And the user clicks on 'checkout button'
Then the user should see 'Checkout - Delivery Address page'

Scenario: Cart_AC5_1 Authenticated user with saved shipping and payment information clicks checkout button
Meta:
@open
Given the user is authenticated as user with saved shipping or payment information
When the user adds product to cart from PDP page
And the user clicks on 'cart icon from header'
And the user clicks on 'checkout button'
Then the user should see Checkout - Order Review page
