Scenario: Footer_AC2_1 User navigates to the website footer and checks the display
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see [component]

Examples:
|component|
|Promo slot|
|Global promo slot / my style promo|
|Global promo slot / twitter feed|
|247rue logo|
|social icons|
|link to download the native app|
|rue Gift Cards link|
|top level menu items and listed out subcategory links|
|My account links|
|Customer service links|


Scenario: Footer_AC3_1 User navigates to the footer and checks the my account menu item display
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see [component]

Examples:
|component|
|Account settings My Account menu in footer|
|order history My Account menu in footer|
|returns in My Account menu footer|
|store credit My Account menu in footer|

Scenario: Footer_AC4_1 User navigates to the footer and checks the customer service menu item display
Meta:
@open
Given the user in on homepage
Then the user should see [component] 

Examples:
|component|
|contact us in Customer service menu from footer|
|shipping info in Customer service menu from footer|
|returns and exchanges in Customer service menu from footer|
|rue Gift Cards link in Customer service menu from footer|
|FAQs in Customer service menu from footer|
|terms and conditions in Customer service menu from footer |