Scenario: Footer_AC5_1 User navigates to the website footer and clicks on the facebook icon
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'facebook icon from footer'
Then the user should see 'facebook.com/247rue page'

Scenario: Footer_AC6_1 User navigates to the website footer and clicks on the twitter icon
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'twitter icon from footer'
Then the user should see 'twitter.com/247rue page'

Scenario: Footer_AC7_1 User navigates to the website footer and clicks on the google+ icon
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on 'google+ icon from footer'
Then the user should see 'plus.google.com/247rue'
