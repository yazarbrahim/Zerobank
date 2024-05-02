package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(xpath = "//*[@id='onlineBankingMenu']/div/strong")
    public WebElement OnlineBankingElement;
    @FindBy(xpath = "//span [@ id='account_activity_link']")
    public WebElement accountActivityElement;
    @FindBy(id = "aa_accountId")
    public WebElement SelectElement;
    @FindBy(css = "[value = '1']")
    public WebElement savingsElement;
    @FindBy(id = "aa_accountId")
    public WebElement list;
    @FindBy(id = "aa_accountId")
    public WebElement dropdownAccounts;
    @FindBy(xpath = "//table//th")
    public List<WebElement> showTransactionsColumns;

    public Select getList() {
        return new Select(list);
    }

    public void OnlineBankingElement() {
        OnlineBankingElement.click();
    }
    public void AccountActivityLinkClick() {
        accountActivityElement.click();
    }

    public void AccountActivityTitle() {
        String title = Driver.get().getTitle();
    }

    public String getDefaultSelectedAccountText() {
        Select select = new Select(dropdownAccounts);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        return BrowserUtils.getText(firstSelectedOption);
    }

    public List<String> getAllAccountTypesFromDropDown() {
        Select select = new Select(dropdownAccounts);
        List<WebElement> options = select.getOptions();
        return BrowserUtils.getElementsText(options);
    }

    public List<String> getShowTransactionsColumnTexts() {
        return BrowserUtils.getElementsText(showTransactionsColumns);
    }


}
