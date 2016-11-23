Scenario: Footer_AC2_1 User navigates to the website footer and checks the display
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
The the user should see [component] in footer

Examples:
|component|
|Promo slot / my style|
|247rue logo|
|social icons|
|back to top link|
|women category link|
|men category link|
|brands category link|
|my style expandable menu item|
|my account expandable menu item|
|Customer service expandable menu item|
|My account links|
|Customer service links|

Scenario: Footer_AC3_1 User clicks on the my style menu item and checks the expanded menu display
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on style menu from footer
Then the user should see [element]

Examples:
|element|
|my products|
|my brands|
|my collections|
|my sizes|
|my feed|

Scenario: Footer_AC4_1 User clicks on the my account menu item and checks the expanded menu display
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on my account menu from footer
Then the user should see [element]

Examples:
|element|
|Account settings|
|order history|
|returns|
|store credit|

Scenario: Footer_AC5_1 User clicks on the customer service menu item and checks the expanded menu display
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on customer service menu from footer
Then the user should see [element]

Examples:
|customer care home|
|contact us|
|shipping info|
|returns and exchanges|
|rue Gift Cards link|
|FAQs|
|terms and conditions|

Scenario: Footer_AC6_1 User navigates to the website footer and clicks on an expandable footer menu item.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on expandable menu
Then the user should see that subcategories as displayed in accordion fashion

Scenario: Footer_AC1_1 User browses the website for global links and corporate information
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user 
Global links and corporate information can be found at the bottom of every page in the footer

Scenario: Footer_AC10_1 User navigates to the footer and clicks the back to top link
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on back to top link
Then the user should be redirected to top of the page

Scenario: Footer_AC11_1 User navigates to the footer and clicks the concierge telephone number link.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on concierge telephone number link
Then the user should see menu to initiate direct call
#The mobile menu is displayed for the user to initiate the direct call to the number.
