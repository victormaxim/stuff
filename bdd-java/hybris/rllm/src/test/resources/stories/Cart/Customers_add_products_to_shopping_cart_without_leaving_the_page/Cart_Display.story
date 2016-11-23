Scenario: Cart_AC2_1 User clicks the cart icon in the website header and checks the display - in stock product
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the users adds in stock product to cart from PDP
When the user clicks on 'cart icon from header'
Then the user should see [component]

Examples:
|component|
|Checkout button in cart|
|promotion - if any in cart|
|cart subtotal value in cart|
|product image in cart |
|quantity dropdown menu in cart |
|x to remove item from cart|
|product title in cart |
|product brand in cart |
|product variants in cart |
|“shipping fulfilled by” message in cart |
|Product Price in cart |
|product level promo notice is displayed at the product level" in cart |

Scenario: Cart_AC2_1 User clicks the cart icon in the website header and checks the display - out of stock product
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the users adds in stock product to cart from PDP
When the user clicks on 'cart icon from header'
Then the user should see [component]

Examples:
|component|
|Checkout button in cart|
|promotion - if any in cart|
|cart subtotal value in cart|
|product image in cart|
|quantity dropdown menu in cart|
|x to remove item from cart in cart|
|product title in cart|
|product brand in cart|
|product variants in cart|
|“shipping fulfilled by” message in cart|
|out of stock message, if applicable in cart|
|Product Price in cart|
|product level promo notice is displayed at the product level" in cart|
