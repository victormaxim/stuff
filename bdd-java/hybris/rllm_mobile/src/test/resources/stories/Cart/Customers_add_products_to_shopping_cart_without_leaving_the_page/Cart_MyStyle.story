Scenario: Cart_AC10_1 Known user adds out of stock item in shopping cart to My Style.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the user adds out of stock product to cart from PDP
And the user clicks on cart icon from header
When clicks on add to mystyle button
Then the user shouldn't see product in cart
And the user should see product in MyStyle - My products
