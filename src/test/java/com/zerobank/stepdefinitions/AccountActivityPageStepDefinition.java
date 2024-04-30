package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccountActivityPageStepDefinition {
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    @FindBy(id = "aa_accountId")
    public WebElement selectElement;

    @And("User click Online Banking tab")
    public void userClickOnlineBankingTab() {
        accountActivityPage.OnlineBankingElement();
    }
    @When("User click the Account activity submodule")
    public void user_click_the_Account_activity_submodule() {
        accountActivityPage.AccountActivityLinkClick();
    }

    @When("Page title is {string}")
    public void page_title_is(String string) {
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String pageTitle = Driver.get().getTitle();
        System.out.println("Page title is: " + pageTitle);
        Assert.assertEquals(string, pageTitle);
    }

    @When("Account drop down default option should be displayed {string}")
    public void account_drop_down_default_option_should_be_displayed(String string) {

        Select select = new Select(accountActivityPage.SelectElement);
        select.selectByValue("1");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), string);
        System.out.println("selec::: " + select.getFirstSelectedOption().getText());
    }

    @Then("User click the drop-down arrow")
    public void user_click_the_drop_down_arrow() {
        WebElement allOption = accountActivityPage.SelectElement;
        allOption.click();
        //Assert.assertEquals();
    }

    @Then("All options {string}, {string}, {string}, {string}, {string}, {string}, are displayed")
    public void all_options_are_displayed(String string, String string2, String string3, String string4, String string5, String string6) {
        WebElement allOption = accountActivityPage.SelectElement;
        Select select = new Select(allOption);
        List<WebElement> allOptions = select.getOptions();

        for (WebElement option : allOptions) {
            System.out.println(option.getText());
            // Assert.assertEquals();
        }
    }
}
