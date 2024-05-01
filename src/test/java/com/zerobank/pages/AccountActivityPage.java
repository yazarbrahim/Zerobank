package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

}
