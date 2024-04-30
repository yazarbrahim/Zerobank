@pay_bills_page
Feature: Pay bills page activities

  Background: Open login page and logged in as a authorized user
    Given User is on main page
    When User click the "signing" button
    Then User enters authorized information
    And User click Online Banking tab
    And User click the "Pay Bills" module

  @page-title
  Scenario: Account Activity page should have the title Zero – Pay Bills.
    Then Page Title should be "Zero - Pay Bills"

  @pay_op
  Scenario: user completes a successful Pay operation, The payment was successfully submitted
    Then User select the Payee
    Then User select the account
    Then User enter the amount
    Then User enter the date
    Then User enter the description
    When User clicks the "Pay" button
    And "The payment was successfully submitted." displayed

  @entering_without_amount
  Scenario: Payment without entering the amount
    Then User select the Payee
    Then User select the account
    Then User left the amount box empty
    Then User enter the date
    Then User enter the description
    When User clicks the pay button
    And "Please fill out this field." message displayed

  @entering_without_date
  Scenario: Payment without entering the date
    Then User select the Payee
    Then User select the account
    Then User enter the amount
    Then User left the date box empty
    Then User enter the description
    When User clicks the pay button
    And "Please fill out this field." message displayed on date box


#  @without
#  Scenario Outline: payment <amount>
#    Then User select the Payee
#    Then User select the account
#    Then user enter the <amount> amount and <date> date
#    Then User enter the description
#    When User clicks the pay button
#    And <warning message> message displayed
#  Examples:
#  | amount | date      | warning message             |
#  | 1000   |           | Please fill out this field. |
#  |        | 2020-01-21| Please fill out this field. |
#  |        |           | Please fill out this field. |

