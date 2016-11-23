Scenario: Header_AC22_1 Authenticated user hovers over the my account button, clicks account info link from the menu, and checks the display
Meta:
@blocked
@issue RUE-990
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'account info from my account menu'
Then the user should see 'My Account - Dashboard page'

Scenario: Header_AC23_1 Authenticated user hovers over the sign in button, clicks member info link from the menu, and checks the display
Meta:
@blocked
@issue RUE-990
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'member info from my account menu'
Then the user should see 'My Account - Member Information'

Scenario: Header_AC24_1 Authenticated user hovers over the my accountbutton, clicks store addresses link from the menu, and checks the display
Meta:
@blocked
@issue RUE-990
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'store addresses from my account menu'
Then the user should see 'My Account - Address Book page'

Scenario: Header_AC25_1 Authenticated user hovers over the my accountbutton, clicks stored credit cards link from the menu, and checks the display
Meta:
@blocked
@issue RUE-990
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'stored credit cards from my account menu'
Then the user should see 'My Account - Payment details'

Scenario: Header_AC26_1 Authenticated user hovers over the my accountbutton, clicks order history link from the menu, and checks the display
Meta:
@blocked
@issue RUE-990
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'order history from my account menu'
Then the user should see 'My Account - Order history'

Scenario: Header_AC27_1 Authenticated user hovers over the my accountbutton, clicks my returns link from the menu, and checks the display
Meta:
@blocked
@issue RUE-990
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'my returns from my account menu'
Then the user should see 'My Account - Order history - My returns'

Scenario: Header_AC28_1 Authenticated user hovers over the my accountbutton, clicks my credit link from the menu, and checks the display
Meta:
@blocked
@issue RUE-990
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'my credit from my account menu'
Then the user should see 'My Account - Store credit'

Scenario: Header_AC29_1 Authenticated user hovers over the my accountbutton, clicks notification settings link from the menu, and checks the display
Meta:
@blocked
@issue RUE-990
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'notifications settings from my account menu'
Then the user should see 'My Account - Notifications Preferences'

Scenario: Header_AC30_1 Authenticated user hovers over the my accountbutton, clicks logout link from the menu, and checks the display
Meta:
@automated
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'Logout from My Account menu'
Then the user should see 'Login page'
