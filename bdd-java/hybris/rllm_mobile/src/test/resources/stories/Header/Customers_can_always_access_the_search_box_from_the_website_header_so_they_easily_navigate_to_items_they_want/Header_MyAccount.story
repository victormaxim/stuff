Scenario: Header_AC8_1 Authenticates user navigates to the top of any page of the website and clicks the my account button.
Given the user authenticates with 'rueQAMaleUser@mailinator.com' and 'rueQAMalePassword'
And the user is on 'Homepage' page
When the user clicks on MyAccount link
Then the user should see MyAccount dashboard page
