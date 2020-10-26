Feature: Test if it is possible to register a new account

  Scenario Outline: Move from main page to registration site and check if all data is entered correctly, registration
    finishes successfully
    Given User is on the main page
    When User clicks Sign-in button
    And Enters an <Email> and click Create an Account
    And Enters as personal information <FirstName> and <LastName>
    And Enters address information <FirstName> <LastName> <Address> <City> <Zip> <Phone>
    And Clicks register
    Then 'Welcome to your account.' message is visible

    Examples:
      | Email | FirstName | LastName | Address | City | Zip | Phone |
      | qub48344@eoopy.com | Adam | Malysz | Poziomkowa | Wisla | 12345 | 123456789 |
