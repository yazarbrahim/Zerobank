package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends BasePage {

    @FindBy(linkText = "Pay Bills")
    public WebElement payBillsElement;

    @FindBy(id = "sp_payee")
    public WebElement payeeElement;

    @FindBy(id = "sp_account")
    public WebElement accountElement;

    @FindBy(id = "sp_amount")
    public WebElement amountElement;

    @FindBy(id = "sp_date")
    public WebElement dateElement;

    @FindBy(id = "sp_description")
    public WebElement descriptionElement;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButtonElement;

    @FindBy(id = "alert_content")
    public WebElement messageElement;

    @FindBy(id = "ui-datepicker-div")
    public WebElement dateTableElement;

    @FindBy(xpath = "//*[. = 'Please fill out this field'")
    public WebElement alert1;

    public void selectPayee() {
        //  Select select = new Select()
        new Select(payeeElement).selectByVisibleText("Sprint");
    }

    public void selectAccount() {
        //  Select select = new Select()
        new Select(accountElement).selectByVisibleText("Savings");
    }

    public void enteramount(String amount) {
        amountElement.sendKeys(amount);
    }

    public void enterDate(String date) {
        dateElement.click();
        dateElement.sendKeys(date);
        // dateElement.sendKeys("");
        // dateTableElement.sendKeys("2020-01-29");
    }

    public void clickPayButton() {
        payButtonElement.click();
    }

    public String messageDisplayed() {
        String message = messageElement.getText();
        //messageElement.getText();
        return message;
    }

    public String amountWarningMessage() {
        String warningMessage = amountElement.getAttribute("validationMessage");
//        String message =  Driver.get().findElement(By.id("sp_amount")).getAttribute("validationMessage");
        return warningMessage;
    }

    public String dateWarningMessage() {
        String warningMessage = dateElement.getAttribute("validationMessage");
        return warningMessage;
    }


}
