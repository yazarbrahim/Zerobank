package com.zerobank.stepdefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {

    @Before
    public void setup() {
        System.out.println("Test setup!");
        Driver.get().manage().window().maximize();
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Test failed!");
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        } else {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
            System.out.println("Cleanup!");
            System.out.println("Test completed!");
        }
        Driver.close();
    }

}
