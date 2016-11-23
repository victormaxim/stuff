Scenario: Search_AC1_1 User navigates the website to enter their terms of search.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see search box


Scenario: Search_AC_2m_1 User navigates the website, curses into the search box and clicks the back button.
The page from which the user originally clicked the search button to enable the search bar is displayed.
