Scenario: Cart_AC2_1 User clicks the cart icon in the website header and checks the display - stock product
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the users add product to cart from PDP
When the user clicks on cart icon from header
Then the user should see [component] in cart

Examples:
|component|
|Checkout button|
|promotion - if any|
|cart subtotal value|
|product list. each product has the following components:|
|product image|
|quantity dropdown menu|
|x to remove item from cart|
|product title|
|product brand|
|product variants|
|“shipping fulfilled by” message|
|out of stock message, if applicable|
|Product Price|
|product level promo notice is displayed at the product level"|

Scenario: Cart_AC2_2 User clicks the cart icon in the website header and checks the display - out of stock product
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the users add product to cart from PDP
When the user clicks on cart icon from header
Then the user should see [component] in cart

Examples:
|component|
|Checkout with paypal button|
|Checkout button|
|promotion - if any|
|cart subtotal value|
|product list. each product has the following components:|
|product image|
|quantity dropdown menu|
|x to remove item from cart|
|product title|
|product brand|
|product variants|
|“shipping fulfilled by” message|
|out of stock message, if applicable|
|Product Price|
|product level promo notice is displayed at the product level"|