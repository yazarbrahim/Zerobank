package com.zerobank.stepdefinitions;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;


public class AccountSummaryStepDefinitions {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @When("User click the Account Summary submodule")
    public void user_click_the_Account_summary_submodule() {
        accountSummaryPage.AccountSummaryLinkClick();
    }

    @Then("User Should see {string}, {string}, {string}, {string}")
    public void user_Should_see(String string, String string2, String string3, String string4) {
        accountSummaryPage.waitUntilLoaderMaskDisappear();
        Assert.assertEquals(string, accountSummaryPage.CashAccountsElement.getText());
        Assert.assertEquals(string2, accountSummaryPage.InvestmentAccountsElemenent.getText());
        Assert.assertEquals(string3, accountSummaryPage.CreditAccountsElement.getText());
        Assert.assertEquals(string4, accountSummaryPage.LoanAccountsElement.getText());
    }

    @Then("User Should see that account types are displayed")
    public void user_Should_see_that_account_types_are_displayed(List<String> dataTable) {
        BrowserUtils.waitForPageToLoad(10);
        accountSummaryPage.getAccountTypesNames();
        int text = accountSummaryPage.getAccountTypesNames().size();
        System.out.println("There are " + text + " Account types display --> " + dataTable);
        Assert.assertEquals(dataTable, accountSummaryPage.getAccountTypesNames());
    }
    @Then("User should see following credit accounts columns")
    public void user_should_see_following_credit_accounts_columns(List<String> expectedCreditAccountColumns) {
        List<String> actualList = accountSummaryPage.getCreditAccountsColumnsTexts();
        accountSummaryPage.getCreditAccountsColumnsTexts();
        int CreditNames = accountSummaryPage.getCreditAccountsColumnsTexts().size();
        System.out.println("There are " + CreditNames + " Credit names display --> " + expectedCreditAccountColumns);
        Assert.assertEquals(expectedCreditAccountColumns, actualList);

    }

    @Then("Account tables must have displayed on the columns")
    public void account_tables_must_have_displayed_on_the_columns(List<String> dataTable) {
        System.out.println("Account table columns are: " + dataTable);
        accountSummaryPage.waitUntilLoaderMaskDisappear();
        Assert.assertEquals(dataTable, accountSummaryPage.getAccountTablesColumns());
    }

}
