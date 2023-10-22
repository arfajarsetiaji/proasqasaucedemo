Feature: Login

  @Regression @DDT @PositiveAndNegative @Login
  Scenario Outline: User login with multiple credentials
    Given the user is on the login page
    When the user enters "<email>" as username and "<password>" as password
    And the user clicks the login button
    Then the login should be "<status>"

    Examples:
      | email                   | password     | status     |
      | standard_user           | secret_sauce | success    |
      | locked_out_user         | secret_sauce | locked_out |
      | problem_user            | secret_sauce | success    |
      | performance_glitch_user | secret_sauce | success    |
      | error_user              | secret_sauce | success    |
      | visual_user             | secret_sauce | success    |
      | not_a_user              | secret_sauce | failed     |