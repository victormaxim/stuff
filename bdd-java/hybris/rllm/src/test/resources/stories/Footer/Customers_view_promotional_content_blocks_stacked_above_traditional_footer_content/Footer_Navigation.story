Scenario: Footer_AC1_1 User browses the website for global links and corporate information
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on [page] page
Then the user should see 'global links'
And the user should see 'corporate information'

Examples:
|page|
|homepage|
|plp|
|pdp|
|brands|
|my account|
|my style|


Scenario: Footer_AC9_1 User navigates to the footer and clicks on gift cards link
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'gift cards link from footer'
Then the user should see Gift cards landing page

Scenario: Footer_AC8_1 User navigates to the website footer and clicks on the download our app link
Meta:
@open
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'download our app link'
Then the user should see 'app store page for 247Rue app'
