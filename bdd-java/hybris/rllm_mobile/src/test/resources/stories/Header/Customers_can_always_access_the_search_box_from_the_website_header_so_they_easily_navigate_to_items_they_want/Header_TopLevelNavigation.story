Scenario: Header_AC17_1 User clicks the shop/hamburger icon in the navigation menu and clicks on a top level category
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on shop menu 
And user clicks on top level category
Then the user should see corresponding subcategories
And the user should see search box
And the user should see "ALL X Products"

Scenario: Header_AC18_1 User in the shop menu for a top level category clicks into the search box.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
And the user clicks on shop menu 
And user clicks on top level category
When the user searches for 'keyword' in shop menu search box
Then the user should see search results from that category

Scenario: Header_AC19_1 User clicks into a top level menu item then clicks on a subcategory
Given the user in on homepage
And the user clicks on shop menu
And the user clicks on top level category 
When the user clicks on subcategory
Then the user should see next level subcategories expanded

Scenario: Header_AC20_1 User clicks into a top level menu item, clicks on a subcategory to expand, then clicks on a category of interest.
Given the user in on homepage
And the user clicks on shop menu
And the user clicks on top level category 
When the user clicks on subcategory
And the user clicks on category of interest
Then the user should see corresponding PLP page
And the user should see faceting and product grid for PLP page

Scenario: Header_AC2_1 User navigates the site for global navigation links and account information.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on [page] page
Then the user should see my account information

Examples:
|page|
|homepage|
|pdp|
|plp|
|brandlanding|
|brandlist|
|myaccount|
