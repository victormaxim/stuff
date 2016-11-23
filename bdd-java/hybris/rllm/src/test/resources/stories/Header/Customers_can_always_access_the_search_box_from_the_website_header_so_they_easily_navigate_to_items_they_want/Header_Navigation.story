Scenario: Header_AC2_1 User navigates the site for global navigation links and account information - homepage
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see 'Top level navigation menu'
And the user should see 'My Account menu'
And the user should see 'My Style menu'
And the user should see 'Logo from header'
And the user should see 'Rue365 promo link'
And the user should see 'Cart icon'
And the user should see 'Search box'

Scenario: Header_AC2_2 User navigates the site for global navigation links and account information - plp
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Plp' page
Then the user should see 'Top level navigation menu'
And the user should see 'My Account menu'
And the user should see 'My Style menu'
And the user should see 'Logo from header'
And the user should see 'Rue365 promo link'
And the user should see 'Cart icon'
And the user should see 'Search box'

Scenario: Header_AC2_3 User navigates the site for global navigation links and account information - pdp
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Pdp' page
Then the user should see 'Top level navigation menu'
And the user should see 'My Account menu'
And the user should see 'My Style menu'
And the user should see 'Logo from header'
And the user should see 'Rue365 promo link'
And the user should see 'Cart icon'
And the user should see 'Search box'

Scenario: Header_AC2_4 User navigates the site for global navigation links and account information - brand landing
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand Landing' page
Then the user should see 'Top level navigation menu'
And the user should see 'My Account menu'
And the user should see 'My Style menu'
And the user should see 'Logo from header'
And the user should see 'Rue365 promo link'
And the user should see 'Cart icon'
And the user should see 'Search box'

Scenario: Header_AC2_5 User navigates the site for global navigation links and account information - brand list
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Brand List' page
Then the user should see 'Top level navigation menu'
And the user should see 'My Account menu'
And the user should see 'My Style menu'
And the user should see 'Logo from header'
And the user should see 'Rue365 promo link'
And the user should see 'Cart icon'
And the user should see 'Search box'

Scenario: Header_AC2_6 User navigates the site for global navigation links and account information - collections
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Collections' page
Then the user should see 'Top level navigation menu'
And the user should see 'My Account menu'
And the user should see 'My Style menu'
And the user should see 'Logo from header'
And the user should see 'Rue365 promo link'
And the user should see 'Cart icon'
And the user should see 'Search box'

Scenario: Header_AC2_7 User navigates the site for global navigation links and account information - my account
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'My Account' page
Then the user should see 'Top level navigation menu'
And the user should see 'My Account menu'
And the user should see 'My Style menu'
And the user should see 'Logo from header'
And the user should see 'Rue365 promo link'
And the user should see 'Cart icon'
And the user should see 'Search box'

Scenario: Header_AC2_8 User navigates the site for global navigation links and account information - my style
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'My Style' page
Then the user should see 'Top level navigation menu'
And the user should see 'My Account menu'
And the user should see 'My Style menu'
And the user should see 'Logo from header'
And the user should see 'Rue365 promo link'
And the user should see 'Cart icon'
And the user should see 'Search box'

Scenario: Scenario: Header_AC1_3 Negative: Authenticated user navigates shouldn't see navigations links and account information on checkout
Meta:
@automated
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'PDP' page
When the user adds product to cart from PDP
And the user is on 'Checkout' page
Then the user shouldn't see 'Top level navigation menu'
And the user shouldn't see 'My Account menu'
And the user shouldn't see 'My Style menu'

