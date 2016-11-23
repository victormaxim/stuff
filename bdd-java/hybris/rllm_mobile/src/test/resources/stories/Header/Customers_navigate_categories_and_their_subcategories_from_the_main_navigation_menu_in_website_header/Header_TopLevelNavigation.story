Scenario: Header_AC17_1 User clicks the shop/hamburger icon in the navigation menu and clicks on a top level category
Given the user is on homepage
When the user clicks on shop icon
And the user clicks on 'Mens' top level category
Then the user should see corresponding subcategories
And the user should see search box
And the user should see ALL X products

Scenario: Header_AC18_1 User in the shop menu for a top level category clicks into the search box.
Given the user is on homepage
And the user clicks on shop menu
When the user clicks on search box
And the user types 'red'
Then the results are from that category
#Mobile keyboard is enabled and the user can search for items within the selected category

Scenario: Header_AC19_1 User clicks into a top level menu item then clicks on a subcategory
Given the user is on homepage
When the user clicks on shop menu
And the user clicks on 'Bags' subcategory
Then the user should see next level subcategories

Scenario: Header_AC20_1 User clicks into a top level menu item, clicks on a subcategory to expand, then clicks on a category of interest.
Given the user is on homepage
When the user clicks on shop menu
And the user clicks on subcategory to expand
And the user clicks on category
Then the user should see PLP page for that subcategory

