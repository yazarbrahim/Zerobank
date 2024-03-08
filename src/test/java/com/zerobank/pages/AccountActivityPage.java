package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityPage extends BasePage {

    @FindBy(linkText = "Account Activity")
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

    public void AccountActivityLinkClick() {
        accountActivityElement.click();
    }

    public void AccountActivityTitle() {
        String title = Driver.get().getTitle();
    }

//    public void DefaultSavings(){
//        Select select = new Select(SelectElement);
//        select.selectByValue("1");
//
//
//
//    }


}
