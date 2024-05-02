package com.zerobank.stepdefinitions;
import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PurchaseForeignCurrencyStepDefinitions {

    PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();

    @When("User {string} click module")
    public void userClickModule(String string) {
        BrowserUtils.wait(5);
        purchaseForeignCurrencyPage.clickForeignCurrencyButton();
        BrowserUtils.wait(5);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> foreignCurrencyList) {
        BrowserUtils.wait(5);
        purchaseForeignCurrencyPage.ForeignCurrencyTab.click();
        BrowserUtils.wait(5);
        List<String> actualForeignCurrencyList = purchaseForeignCurrencyPage.getForeignCurrencyList();
        BrowserUtils.wait(2);
        actualForeignCurrencyList.remove(0);
        System.out.println(actualForeignCurrencyList);
        System.out.println(foreignCurrencyList);
        Assert.assertTrue(actualForeignCurrencyList.containsAll(foreignCurrencyList));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        purchaseForeignCurrencyPage.ForeignCurrencyTab.click();
        BrowserUtils.wait(5);
        purchaseForeignCurrencyPage.enterValue(20);
        purchaseForeignCurrencyPage.clickCalculate();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        try {
            Alert alert = Driver.get().switchTo().alert();
            alert.accept();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        purchaseForeignCurrencyPage.ForeignCurrencyTab.click();
        BrowserUtils.wait(5);
        purchaseForeignCurrencyPage.currencyDropDownMenu.click();
        purchaseForeignCurrencyPage.select.selectByVisibleText("Eurozone (euro)");
        purchaseForeignCurrencyPage.clickCalculate();
    }

}
