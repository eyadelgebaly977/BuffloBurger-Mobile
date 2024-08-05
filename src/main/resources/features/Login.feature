Feature: Buffalo Burger Login

  Scenario: Verify that user can login with valid phone number and password
    Given I open the app
    When I enter a valid phone number "01003803007"
    And I click on the continue button
    And I click on the continue button again
    And I enter a valid password "Eyad123@"
    And I click on the login button
    Then I should see the user data section "Enter your details"

  Scenario: Verify that user can not login with valid phone number and invalid password
    Given I open the app
    When I enter a valid phone number "01003803007"
    And I click on the continue button
    And I click on the continue button again
    And I enter an invalid password "Eyad123@@"
    And I click on the login button
    Then I should see the error message "Wrong password"

  Scenario: Verify that password is visible after clicking the eye icon
    Given I open the app
    When I enter a valid phone number "01003803007"
    And I click on the continue button
    And I click on the continue button again
    And I enter an invalid password "Eyad123@@"
    And I click on the eye icon
    Then the password field should display the password "Eyad123@@"
