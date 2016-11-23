Scenario: Cart_AC5_1 Authenticated user with saved shipping and payment information clicks checkout button
Given the user is authenticated as user with saved shipping or payment information
When the user adds product to cart from PDP page
And the user navigates to cart from header
And the user clicks on checkout button
Then the user should see Checkout - Order Review page

