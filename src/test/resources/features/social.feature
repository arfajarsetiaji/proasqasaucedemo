Feature: Social

  @Regression @Positive @Social
  Scenario: User visits Sauce Labs Twitter account
    Given the user is logged in as standard user for visiting social account
    And the user is on the product page for visiting social account
    When the user click Twitter link on the footer
    Then the user should be redirected to Sauce Labs Twitter account

  @Regression @Positive @Social
  Scenario: User visits Sauce Labs Facebook account
    Given the user is logged in as standard user for visiting social account
    And the user is on the product page for visiting social account
    When the user click Facebook link on the footer
    Then the user should be redirected to Sauce Labs Facebook account

  @Regression @Positive @Social
  Scenario: User visits Sauce Labs Linkedin account
    Given the user is logged in as standard user for visiting social account
    And the user is on the product page for visiting social account
    When the user click Linkedin link on the footer
    Then the user should be redirected to Sauce Labs Linkedin account