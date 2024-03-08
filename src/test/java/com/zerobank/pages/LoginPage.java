package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "[id = 'signin_button']")
    public WebElement signinButton;

    @FindBy(css = "[id = 'user_login']")
    public WebElement loginInPutBox;

    @FindBy(css = "[id = 'user_password']")
    public WebElement passwordInputBox;

    @FindBy(css = "[class = 'alert alert-error']")
    public WebElement warningMessageWebElement;

    @FindBy(css = "[id = 'user_remember_me']")
    public WebElement keepMeSignInBox;


    public void loginWithCredentials(String userName, String password) {

//    WebElement submitButton = Driver.get().findElement(By.cssSelector("[id = 'signin_button']"));
//    submitButton.click();  we have to write new method for this attribute
        loginInPutBox.sendKeys(userName);
        passwordInputBox.sendKeys(password, Keys.ENTER);

    }

//    public void loginWithInValidCredentials(String userName, String password){
//
////    WebElement submitButton = Driver.get().findElement(By.cssSelector("[id = 'signin_button']"));
////    submitButton.click();  we have to write new method for this attribute
//        loginInPutBox.sendKeys(userName);
//        passwordInputBox.sendKeys(password, Keys.ENTER);
//
//        // warningMessage.getAttribute()
//
//    }


    public void signinButton() {

//    WebElement submitButton = Driver.get().findElement(By.cssSelector("[id = 'signin_button']"));
//           submitButton.click();

        signinButton.click();

    }

    public void warningMessage() {
        String warningMessageText = Driver.get().findElement(By.cssSelector("[class = 'alert alert-error']")).getText();
    }

    public void selectKeepMeSignInBox() {
        BrowserUtils.waitForClickablility(keepMeSignInBox, 10);
        keepMeSignInBox.click();
        BrowserUtils.wait(2);

    }

    @FindBy(css = "[href = '/forgot-password.html']")
    public WebElement forggetYourPassword;

    public void forgetpasswordLink() {
        forggetYourPassword.click();
    }


}
