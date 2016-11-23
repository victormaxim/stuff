Scenario: Header_AC4_1 Authenticated user navigates to the top of any page of the website and checks the display.
Given the authenticated user is on homepage
Then the user should see [component]
"The global website header is displayed with the following components:
Examples:
|component|
|My Account - Link| 
|My Style - Link |
|Cart icon - button|
|Search box|
|Top level navigation menu"|
|247Rue logo|

Scenario: Header_AC6_1 Authenticated user navigates to the top of any page of the website and checks the display.
Given authenticated user is on [page]
Then the user should see [component]

Examples:
|component|
|247Rue logo|
|My Account - Link| 
|My Style - Link |
|Cart icon - button|
|Search icon|
|Top level navigation menu"|

Scenario: Header_AC16_1 User clicks the shop/hamburger icon in the navigation menu and checks the display
"The top level category menu slides out from the left side of the screen and shows the following menu items:
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on shop menu
Then the user should see [category]

Examples:
|WOMEN|
|MEN|
|KIDS|
|BRANDS|
|COLLECTIONS|
|SHOES|
|ACCESSORIES & HANDBAGS|
