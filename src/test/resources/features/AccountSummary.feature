@Account_summary
Feature: Account summary

  Background: Open login page and logged in as a authorized user
    Given User is on main page
    When User click the "signing" button
    Then User enters authorized information

  @account_summary_title
  Scenario: Account summary page title
   #  Given I am on the login page
   #  When User logs in as an authorized user
    And User verify that "Zero - Account Summary" page title displayed

  @account_types
  Scenario: Account summary page have following account types: Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts.
    Then User Should see "Cash Accounts", "Investment Accounts", "Credit Accounts", "Loan Accounts"

  @account_types2
  Scenario: Verifies account types
    Then User Should see that account types are displayed
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  @account_tables_columns
  Scenario: Verifies Credit Accounts tables must have columns Account, Credit Card and Balance.
    Then Account tables must have displayed on the columns
      | Account Credit Card Balance |

#  @account_tables_columns failed
#  Scenario: Verifies Credit Accounts tables must have columns Account, Credit Card and Balance.
#    Then Account tables must have "[Account Credit Card Balance]" displayed on the columns
#
