@login_page
Feature: Login to the application

  As a authorized user should be able to login to the application
  under with valid credentials.

  @login_valid_credentials @smoke_test @login_invalid_credentials
  Scenario: Login the application
    Given User is on main page
    When User click the "signing" button
    Then User enters authorized information
    And User verify that "Zero - Account Summary" page title displayed

  @login_invalid_credentials
  Scenario Outline: Login with wrong cradentials
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

#  @navigate
#  Scenario: Navigate to submodules
#    Given User is on main page
#    When User click the "signing" button
#    Then User enters authorized information
#    And User navigates to "module" then to "sub module"
#    Then Page title should be "title"
#

#  @login_with_roles_ddt2
#  Scenario Outline: Login as <role> and verify page title is correct
#    Given user is on the login page
#    Then user logs in as "<role>"
#    Then user navigates to "<module>" then to "<sub module>"
#    Then the page title should be "<title>"



#  @login
#  Scenario: Login as authorized user
#    Given Login as authorized user
#    Then I am on the login page
#    Then User logs in as an authorized user
#    And Account summary page should be displayed
#
#    @wrong_userName
#  Scenario: Login with wrong username
#    Given I am on the login page
#    Then User enters "wrong" username and "password" password
#    And User verifies that "Login and/or password are wrong." message is displayed
#
#    @blank_userName
#  Scenario: Login with blank username
#    Given I am on the login page
#    Then User enter "password" password
#    And User verifies that "Login and/or password are wrong." message is displayed
#
#  @blank_password
#  Scenario: Login with blank password
#    Given I am on the login page
#    Then User enters "username" in username box
#    And User verifies that "Login and/or password are wrong." message is displayed
#
#  @blank_username_and_password
#  Scenario: Login with blank username and blank password
#    Given I am on the login page
#    Then User is not enters username and password
#    And User verifies that "Login and/or password are wrong." message is displayed
#
#   @keep_me_signed_in
#  Scenario: Select the keep me signed in box
#    Given  I am on the login page
#    Then Click the Keep me signed in box
#    And User verifies that Keep me signed in box is clicked
#
#   @forget_your_password
#   Scenario: Click the forget your password link
#     Given I am on the login page
#     Then Click the forget your password link
#     And Verifies that "Zero - Forgotten Password" page subtitle is displayed
#
