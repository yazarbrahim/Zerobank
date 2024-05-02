package com.zerobank.stepdefinitions;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class PayBillsStepDefinitions {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("User click the {string} module")
    public void user_click_the_module(String string) {
        Driver.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        payBillsPage.payBillsElement.click();
    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String string) {
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String title = Driver.get().getTitle();
        BrowserUtils.waitForPageTitle(string);
        System.out.println("tttiti: " + title);
        Assert.assertEquals(string, title);
    }

    @Then("User select the Payee")
    public void user_select_the_Payee() {
        payBillsPage.selectPayee();
    }

    @Then("User select the account")
    public void user_select_the_account() {
        payBillsPage.selectAccount();
        BrowserUtils.wait(2);
    }

    @Then("User enter the amount")
    public void user_enter_the_amount() {
        String amount = ConfigurationReader.getProperty("enter_amount");
        System.out.println("amount  ==> " + amount);
        payBillsPage.enteramount(amount);
        BrowserUtils.wait(2);
    }

    @Then("User enter the date")
    public void user_enter_the_date() {
        String date = ConfigurationReader.getProperty("enter_date");
        System.out.println("Date is: " + date);
        BrowserUtils.waitForPageToLoad(2);
        payBillsPage.enterDate(date);
        BrowserUtils.wait(1);
    }

    @Then("User enter the description")
    public void user_enter_the_description() {
        payBillsPage.descriptionElement.sendKeys("December Rent");
    }

    @When("User clicks the {string} button")
    public void user_clicks_the_button(String string) {
        BrowserUtils.wait(2);
        payBillsPage.clickPayButton();
        BrowserUtils.wait(2);
    }

    @When("{string} displayed")
    public void displayed(String string) {
        String message = payBillsPage.messageDisplayed();
        Assert.assertEquals(string, message);
        Assert.assertEquals(string, payBillsPage.messageDisplayed());
    }

    @When("User clicks the pay button")
    public void user_clicks_the_pay_button() {
        payBillsPage.clickPayButton();
    }

    @Then("User left the amount box empty")
    public void user_left_the_amount_box_empty() {
        BrowserUtils.waitForPageToLoad(10);
        payBillsPage.enteramount("");
    }

    @When("{string} message displayed")
    public void message_displayed(String string) {
        Assert.assertEquals(string, payBillsPage.amountWarningMessage());

    }

    @Then("User left the date box empty")
    public void user_left_the_date_box_empty() {
        payBillsPage.enterDate("");
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("{string} message displayed on date box")
    public void message_displayed_on_date_box(String string) {
        String dateMessage = Driver.get().findElement(By.id("sp_date")).getAttribute("validationMessage");
        BrowserUtils.waitForPageToLoad(10);
        System.out.println("Actual is: " + dateMessage);
        Assert.assertEquals(string, payBillsPage.dateWarningMessage());
    }

}
