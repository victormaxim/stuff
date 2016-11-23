Scenario: Homepage_AC1_1 User navigates to homepage by accessing the 247rue.com
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
Then the user should see 'Welcome banner'

Scenario: Homepage_AC1_2 User navigates to homepage by clicking the logo from any page
Meta:
@automated
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'Homepage' page
When the user searches for 'red'
And the user clicks on 'logo from header'
Then the user should see 'Welcome banner'

Scenario: Homepage_AC1_3 User navigates to homepage by clicking the Home breadcrumb
Meta:
@automated
Given the user authenticates with 'rueQAFemaleUser@mailinator.com' and 'rueQAFemalePassword'
And the user is on 'Homepage' page
When the user searches for 'red'
And the user clicks on 'Home' link from breadcrumbs
Then the user should see 'welcome banner'