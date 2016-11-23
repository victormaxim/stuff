Scenario: Header_AC4_1 Authenticated user navigates to the top of homepage and checks the display.
Given the user is authenticates as female
And the user is on homepage
Then the user should see [component]

Examples:
|component|
|247Rue logo|
|My Account|
|My Style|
|Cart icon|
|Search box|
|Shop menu|


Scenario: Header_AC5_1 Unauthenticated user navigates to the top of any page other than the homepage or checkout of the website and checks the display.
Given the user is on PLP
Then the user should see [component]

Examples:
|component|
|247Rue logo|
|My Account|
|My Style|
|Cart icon|
|Search icon|
|Shop menu|

Scenario: Header_AC6_1 Authenticated user navigates to the top of any page of the website and checks the display.
Given the user is authenticated as male 
And the user is on PLP
Then the user should see [component]

Examples:
|component|
|247Rue logo|
|My Account|
|My Style|
|Cart icon|
|Search icon|
|Shop menu|


Scenario: Header_AC3_1 Unauthenticated user navigates to the top of the homepage of the website and checks the display.
Given the user is on homepage
Then the user should see [component]

Examples:
|component|
|247Rue logo|
|My Account|
|My Style|
|Cart icon|
|Search box|
|Shop menu|

Scenario: Header_AC16_1 User clicks the shop/hamburger icon in the navigation menu and checks the display
Given the user is on homepage
When the user clicks on shop menu
Then the user should see [option] menu item

Examples:
|option|
|WOMEN|
|MEN|
|KIDS|
|BRANDS|
|COLLECTIONS|
|SHOES|
|ACCESSORIES & HANDBAGS|
|NEW ARRIVALS|
|LIFESTYLE|


Scenario: Header_AC2_1 User navigates the site for global navigation links and account information.
Given the user is on homepage
Then the user should see SignIn link
And the user should see MyStyle link
And the user should see etc
#Site-wide navigation and my account information is found in the website header at the top of every page of the website (except Checkout).

