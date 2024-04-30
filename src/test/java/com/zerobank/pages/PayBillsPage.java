package com.zerobank.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends BasePage {

    @FindBy(xpath = "//span[@ id='pay_bills_link']")
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
        new Select(payeeElement).selectByVisibleText("Sprint");
    }

    public void selectAccount() {
        new Select(accountElement).selectByVisibleText("Savings");
    }

    public void enteramount(String amount) {
        amountElement.sendKeys(amount);
    }

    public void enterDate(String date) {
        dateElement.click();
        dateElement.sendKeys(date);
    }

    public void clickPayButton() {
        payButtonElement.click();
    }

    public String messageDisplayed() {
        String message = messageElement.getText();
        return message;
    }

    public String amountWarningMessage() {
        String warningMessage = amountElement.getAttribute("validationMessage");
        return warningMessage;
    }

    public String dateWarningMessage() {
        String warningMessage = dateElement.getAttribute("validationMessage");
        return warningMessage;
    }


}
