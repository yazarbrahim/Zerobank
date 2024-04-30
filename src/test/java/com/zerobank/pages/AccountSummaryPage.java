package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//*[text() = 'Cash Accounts']")
    public WebElement CashAccountsElement;
    @FindBy(xpath = "//*[text() = 'Account Summary']")
    public WebElement AccountSummaryElement;

    @FindBy(xpath = "//*[text() = 'Investment Accounts']")
    public WebElement InvestmentAccountsElemenent;

    @FindBy(xpath = "//*[text() = 'Credit Accounts']")
    public WebElement CreditAccountsElement;

    @FindBy(xpath = "//*[text() = 'Loan Accounts']")
    public WebElement LoanAccountsElement;

    @FindBy(css = "[class = 'board-header']")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div[3]/div/table/thead")
    public List<WebElement> accountTablesColumnsElement;

    public void pageTitle() {
        Driver.get().getTitle();
    }
    public void AccountSummaryLinkClick() {
        AccountSummaryElement.click();
    }

    public void accountTypes() {
        String CashAccountsText = CashAccountsElement.getText();
        String InvestmentAccountsText = InvestmentAccountsElemenent.getText();
        String CreditAccountsText = CreditAccountsElement.getText();
        String LoanAccountsText = LoanAccountsElement.getText();
    }

    public List<String> getAccountTypesNames() {
        return BrowserUtils.getListOfString(accountTypes);
    }

    public List<String> getAccountTablesColumns() {
        return BrowserUtils.getListOfString(accountTablesColumnsElement);
    }

}
