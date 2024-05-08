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
        BrowserUtils.waitForPageToLoad(2);
        String userName = ConfigurationReader.getProperty("username");
        BrowserUtils.wait(2);
        String passWord = ConfigurationReader.getProperty("password");
        BrowserUtils.wait(2);
        System.out.println("username is ==> " + userName + " - Password is ==> " + passWord);
        loginPage.loginWithCredentials(userName, passWord);
        Driver.get().navigate().back();
    }

    @Then("User verify that {string} page title displayed")
    public void user_verify_that_page_title_displayed(String string) {
        String actualResult = Driver.get().getTitle();
        System.out.println("Actual Result is: " + actualResult);
        BrowserUtils.wait(5);
        Assert.assertEquals("Check your code", string, actualResult);
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
}
