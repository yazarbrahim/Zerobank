package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AccountSummaryStepDefinitions {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

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
        System.out.println(dataTable);
        BrowserUtils.waitForPageToLoad(10);
        accountSummaryPage.getAccountTypesNames();
        int text = accountSummaryPage.getAccountTypesNames().size();
        System.out.println(text);
        Assert.assertEquals(dataTable, accountSummaryPage.getAccountTypesNames());
    }

    @Then("Account tables must have displayed on the columns")
    public void account_tables_must_have_displayed_on_the_columns(List<String> dataTable) {
        System.out.println("Account table columns are: " + dataTable);
        accountSummaryPage.waitUntilLoaderMaskDisappear();
        Assert.assertEquals(dataTable, accountSummaryPage.getAccountTablesColumns());
    }

//    @Then("Account tables must have {string} displayed on the columns")
//    public void account_tables_must_have_displayed_on_the_columns(String string) {
//        System.out.println("Account table columns are: " + string);
//        accountSummaryPage.waitUntilLoaderMaskDisappear();
//       // Assert.assertEquals(string, accountSummaryPage.getAccountTablesColumns());
//
//        System.out.println("Account table columns are: "+ string);
//        List<String> names = accountSummaryPage.getAccountTablesColumns();
//        System.out.println(names + "3444");
//        accountSummaryPage.waitUntilLoaderMaskDisappear();
//        Assert.assertEquals(string, names);
//        System.out.println(names + "3444");
//
//    }

}
