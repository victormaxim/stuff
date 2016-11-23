Scenario: Header_AC35_1 User clicks on a top level category button that is not brands or collections from the navigation bar in the website header - Men top level category
Meta:
@blocked
@issue RUE-993
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'Men top level category'
Then the user should see 'Men PLP page'

Scenario: Header_AC35_2 User clicks on a top level category button that is not brands or collections from the navigation bar in the website header - Women top level category
Meta:
@blocked
@issue RUE-993
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'Women top level category'
Then the user should see 'Women PLP page'

Scenario: Header_AC35_3 User clicks on a top level category button that is not brands or collections from the navigation bar in the website header - Kids top level category
Meta:
@blocked
@issue RUE-993
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'Kids top level category'
Then the user should see 'Kids PLP page'

Scenario: Header_AC36_1 User clicks on a the brand button from the navigation bar in the website header.
Meta:
@blocked
@issue RUE-994
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'Brands top level category'
Then the user should see 'Brand List page'

Scenario: Header_AC37_1 User clicks on a the collection button from the navigation bar in the website header.
Meta:
@waiting
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'Collections top level category'
Then the user should see 'Collections List Page'

Scenario: Header_AC38_1 User hovers over a top level category and clicks the ALL MEN PRODUCTS in the supermenu.
Meta:
@blocked
@issue RUE-993
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'All link from Men top level category'
Then the user should see 'Men category PLP page'

Scenario: Header_AC38_2 User hovers over a top level category and clicks the ALL WOMEN PRODUCTS in the supermenu.
Meta:
@blocked
@issue RUE-993
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'All link from Women top level category'
Then the user should see 'Men category PLP page'

Scenario: Header_AC41_1 User hovers over a top level category in the navigation bar and checks the display
Meta:
@blocked
@@issue RUE-993
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user hovers over 'top level category from header'
Then the user should see 'Product links'
And the user should see 'Subcategory links'
And the user should see 'Children of subcategory links'
And the user should see 'X button'

Scenario: Header_AC43_1 User hovers over a top level category in the navigation bar to reveal the supermenu, then clicks the X and checks the display
Meta:
@blocked
@@issue RUE-993
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user hovers over 'top level category from header'
And the user clicks on 'X button from top level navigation supermenu'
Then the user shouldn't see 'top level navigation supermenu'

Scenario: Header_AC44_1 User hovers over a top level category in the navigation bar and clicks on a subcategory from the supermenu.
Meta:
@blocked
@@issue RUE-993
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user hovers over 'top level category from header'
And the user clicks on 'a subcategory'
Then the user should see 'the PLP page for that subcategory'