package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();
    String actualMessage;

    @Given("User is on main page")
    public void user_is_on_main_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @When("User click the {string} button")
    public void user_click_the_button(String string) {
        loginPage.signinButton();
    }

    @Then("User enters authorized information")
    public void user_enters_authorized_information() {
        BrowserUtils.waitForPageToLoad(10);
        String userName = ConfigurationReader.getProperty("username");
        String passWord = ConfigurationReader.getProperty("password");
        System.out.println("username is ==> " + userName + " - Password is ==> " + passWord);
        loginPage.loginWithCredentials(userName, passWord);
    }

    @Then("User verify that {string} page title displayed")
    public void user_verify_that_page_title_displayed(String string) {
        String actualResult = Driver.get().getTitle();
        System.out.println("Actual Result is: " + actualResult);
        Assert.assertEquals("Check yopur code", string, actualResult);
    }

    @Then("User enters wrong {string} username and {string} password")
    public void user_enters_wrong_username_and_password(String string, String string2) {
        System.out.println("Login with " + string + " username and " + string2 + " password");
        loginPage.loginWithCredentials(string, string2);
    }

    @Then("User verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String string) {
        String warningMessageText = Driver.get().findElement(By.cssSelector("[class = 'alert alert-error']")).getText();
        System.out.println("Warning message is: " + warningMessageText);
        Assert.assertEquals(string, warningMessageText);
    }

    @When("Click the Keep me signed in box")
    public void click_the_Keep_me_signed_in_box() {
        loginPage.selectKeepMeSignInBox();
    }

    @When("User verifies that Keep me signed in box is clicked")
    public void user_verifies_that_Keep_me_signed_in_box_is_clicked() {
//        boolean keepMeSignInBox = loginPage.keepMeSignInBox.isSelected();   // it is also work
//        Assert.assertTrue(keepMeSignInBox);
        Assert.assertTrue(loginPage.keepMeSignInBox.isSelected());
        BrowserUtils.wait(3);

    }

    @Then("Click the forget your password link")
    public void click_the_forget_your_password_link() {
        loginPage.forgetpasswordLink();
    }

    @Then("Verifies that {string} page subtitle is displayed")
    public void verifies_that_page_subtitle_is_displayed(String string) {
        String title = Driver.get().getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(string, title);
    }

//    @Then("User navigates to {string} then to {string}")
//    public void user_navigates_to_then_to(String string, String string2) {
//        loginPage.navigateTo(string, string2);
//    }
//
//    @Then("Page title should be {string}")
//    public void page_title_should_be(String string) {
//
//    }


//    @FindBy(css = "[id = 'signin_button']")
//    public WebElement signinButton;
//
//    @Given("Login as authorized user")
//    public void login_as_authorized_user() {
//        loginPage.signinButton();
//        String UserName = ConfigurationReader.getProperty("username");
//        String Password = ConfigurationReader.getProperty("password");
//        loginPage.loginWithCredentials(UserName, Password);
//    }
//
//
//
//
//    @Then("I am on the login page")
//    public void i_am_on_the_login_page() {
//       System.out.println("I am on the login page");
//        Driver.get().get(ConfigurationReader.getProperty("url"));
//
//       // Driver.get().get(ConfigurationReader.getProperty("url"));
//
//
//    }
//
//    @Then("User logs in as an authorized user")
//    public void user_logs_in_as_an_authorized_user() {
//
//        //PageFactory.initElements(Driver.get(), this);
//       // Driver.get().
//
//        //signinButton.click();
//        loginPage.signinButton();
////        WebElement submitButton = Driver.get().findElement(By.cssSelector("[id = 'signin_button']"));  // second way
////        submitButton.click();
//        String UserName = ConfigurationReader.getProperty("username");
//        String Password = ConfigurationReader.getProperty("password");
//        loginPage.loginWithCredentials(UserName, Password);
//    }
//
//    @Then("Account summary page should be displayed")
//    public void account_summary_page_should_be_displayed() {
//
//        String pageTitle = Driver.get().getTitle();
//        String expectedText = "Zero - Account Summary";
//        BrowserUtils.wait(5);
//        //loginPage.wait(2000);
//        System.out.println(expectedText);
//        System.out.println(pageTitle);
//        Assert.assertEquals(expectedText, pageTitle);
//    }
//
//    //Then User enters "wrong" username and "password" password
//    @Then("User enters {string} username and {string} password")
//    public void user_enters_username_and_password(String string, String string2) {
//        loginPage.signinButton();  // signin button
//        loginPage.loginWithCredentials(string, string2);
//
//        System.out.println("Login with " + string + " username " + string2 + " password");
//
//    }
//
//    @Then("User verifies that {string} message is displayed")
//    public void user_verifies_that_message_is_displayed(String string) {
//
//        //String expectedMessage = "Login and/or password are wrong.";
//        actualMessage = loginPage.warningMessageWebElement.getText();
//        Assert.assertEquals(string, actualMessage);
//        System.out.println(actualMessage);
//        System.out.println("Warning message is: " + string);
//
//    }
//
//    @Then("User enter {string} password")
//    public void user_enter_password(String string) {
//
//        loginPage.signinButton();
//
//        String blankUser = ConfigurationReader.getProperty("blankUserName");
//        //String password = ConfigurationReader.getProperty("password");
//       // loginPage.loginWithInValidCredentials(blankUser, password);
//        loginPage.loginWithCredentials(blankUser, string);
//        BrowserUtils.wait(2);
//        actualMessage = loginPage.warningMessageWebElement.getText();
//        Assert.assertEquals(string, actualMessage);
//        System.out.println(actualMessage);
//        System.out.println("Warning message is2: " + string);
////        String expectedMessage = "Login and/or password are wrong.";
////        String actualMessage = loginPage.warningMessageWebElement.getText();
////        Assert.assertEquals(expectedMessage, actualMessage);
////        System.out.println(actualMessage);
//
//    }
//
//    @Then("User enters {string} in username box")
//    public void user_enters_in_username_box(String string) {
//        loginPage.signinButton();
//        String blankPassword = ConfigurationReader.getProperty("blankPassword");
//        loginPage.loginWithCredentials(string, blankPassword);
//
//    }
//
//    @Then("User is not enters username and password")
//    public void user_is_not_enters_username_and_password() {
//
//    loginPage.signinButton();
//    String blankUser = ConfigurationReader.getProperty("blankUserName");
//    String blankPassword = ConfigurationReader.getProperty("blankPassword");
//    loginPage.loginWithCredentials(blankUser, blankPassword);
//
//    }
//
//    @Then("Click the Keep me signed in box")
//    public void click_the_Keep_me_signed_in_box() {
//        loginPage.signinButton();
//        loginPage.selectKeepMeSignInBox();
//    }
//
//    @Then("User verifies that Keep me signed in box is clicked")
//    public void user_verifies_that_Keep_me_signed_in_box_is_clicked() {
//
//        boolean keepMeSignInBox = loginPage.keepMeSignInBox.isSelected();
//        Assert.assertTrue(keepMeSignInBox);
//       // Assert.assertTrue(loginPage.keepMeSignInBox.isSelected());  // it is also work
//
//    }
//
//    @Then("Click the forget your password link")
//    public void click_the_forget_your_password_link() {
//        loginPage.signinButton();
//        loginPage.forgetpasswordLink();
//    }
//
//    @Then("Verifies that {string} page subtitle is displayed")
//    public void verifies_that_page_subtitle_is_displayed(String string) {
//
//    String actualResult = Driver.get().getTitle();
//    Assert.assertEquals(string, actualResult);
//        System.out.println("page title is: " + actualResult);
//
//
//
//    }
//


}
