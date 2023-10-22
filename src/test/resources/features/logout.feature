Feature: Logout

  @Regression @Positive @Logout
  Scenario: User log out from sauce demo website
    Given the user is logged in as standard user for log out from sauce demo website
    When the user clicks sidebar menu button
    And the user clicks logout menu item
    Then the user should be logged out and redirected to login page