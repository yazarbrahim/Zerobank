@account_activity
Feature: Testing Account Activity Page

  Background: Open login page and logged in as a authorized user
    Given User is on main page
    When User click the "signing" button
    Then User enters authorized information
    And User click Online Banking tab
    When User click the Account activity submodule

  @account_activity_title
  Scenario: Account Activity page should have the title Zero - Account activity
    And Page title is "Zero - Account Activity"

  @savings
  Scenario: Default option is Savings
    And Account drop down default option should be displayed "Savings"

  @all_options
  Scenario: Second option is Checking
    Then User click the drop-down arrow
    And All options "Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage", are displayed

  @account_activity_types @demo
  Scenario: Account types
    Then The user should be able to see "Savings" account type as default
    And The user should be able to see following account types at the drop down menu
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

    And The user should be able to see followings Show Transactions table columns
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |