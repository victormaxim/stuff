Scenario: Cart_AC12_1 Item in cart is no longer available on the website.
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the user adds out of stock product to cart from PDP
When the user clicks on 'cart icon from header'
Then the user should see [component]

Examples:
|component|
|out of stock message|
|proceed to checkout button but cannot proceed to checkout|
|add to my style button|
|remove button|

