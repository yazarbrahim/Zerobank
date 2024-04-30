@login_page
Feature: Login page testing

  As a authorized user should be able to login to the application
  under with valid credentials.

  @login_valid_credentials @smoke_test @login_invalid_credentials
  Scenario: Login the application
    Given User is on main page
    When User click the "signing" button
    Then User enters authorized information
    And User verify that "Zero - Personal Banking - Loans - Credit Cards" page title displayed

  @login_invalid_credentials
  Scenario Outline: Login with wrong credentials
    Given User is on main page
    When User click the "signing" button
    Then User enters wrong "<username>" username and "<password>" password
    And User verifies that "Login and/or password are wrong." message is displayed

    Examples:
      | username      | password      |
      | wrongUsername | wrongPassword |
      | wrongUsername | password      |
      | username      | wrongpassword |
      | username      |               |
      |               | password      |
      |               |               |
      | USERNAME      | PASSWORD      |
      | USERNAME      | password      |
      | username      | PASSWORD      |

  @keep_me_signed_in
  Scenario: Select the keep me sign in box
    Given  User is on main page
    Then User click the "signing" button
    When Click the Keep me signed in box
    And User verifies that Keep me signed in box is clicked

  @forget_your_password
  Scenario: Click the forget your password link
    Given User is on main page
    Then User click the "signing" button
    Then Click the forget your password link
    And Verifies that "Zero - Forgotten Password" page subtitle is displayed