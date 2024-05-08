package com.zerobank.pages;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public BasePage() {  // first create this method
        PageFactory.initElements(Driver.get(), this);
    }

    public boolean waitUntilLoaderMaskDisappear() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 20);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='loader-mask shown']")));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Loader mask not found!");
            e.printStackTrace();
            return true;
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void navigateTo(String moduleName, String subModuleName) {
        Actions actions = new Actions(Driver.get());
        String moduleLocator = "//*[normalize-space()='" + moduleName + "' and @class='title title-level-1']";
        String subModuleLocator = "//*[normalize-space()='" + subModuleName + "' and @class='title title-level-2']";
        WebDriverWait wait = new WebDriverWait(Driver.get(), 25);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator)));
        WebElement module = Driver.get().findElement(By.xpath(moduleLocator));
        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.elementToBeClickable(module));
        waitUntilLoaderMaskDisappear();
        BrowserUtils.clickWithWait(module);
        WebElement subModule = Driver.get().findElement(By.xpath(subModuleLocator));
        if (!subModule.isDisplayed()) {
            actions.doubleClick(module).doubleClick().build().perform();
            try {
                wait.until(ExpectedConditions.visibilityOf(subModule));
            } catch (Exception ex) {
                ex.printStackTrace();
                BrowserUtils.clickWithJS(module);
            }
        }
        BrowserUtils.clickWithWait(subModule);
        BrowserUtils.waitForPageToLoad(10);
    }

    public void waitForPageSubTitle(String pageSubtitleText) {
        new WebDriverWait(Driver.get(), 10).until(ExpectedConditions.textToBe(By.cssSelector("h1[class='oro-subtitle']"), pageSubtitleText));
    }
    public void navigateBetweenPages(String tab){
        Actions actions = new Actions(Driver.get());
        WebElement pageTab = Driver.get().findElement(By.linkText(tab));
        actions.moveToElement(pageTab).pause(200).click().perform();
        BrowserUtils.wait(5);
    }

}
