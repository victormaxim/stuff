Scenario: Cart_AC9_1 Authenticated user adds out of stock item in shopping cart to My Style.
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the user adds out of stock product to cart from PDP
When the user clicks on 'cart icon from header'
And the user clicks on 'add to mystyle button'
Then the user shouldn't see 'product in cart'
And the user should see 'product in MyStyle - My products'

Scenario: Cart_AC10_1 Known user adds out of stock item in shopping cart to My Style.
Meta:
@open
#The product is removed from shopping cart and added to My Products
