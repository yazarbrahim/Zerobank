package com.zerobank.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/zerobank/stepdefinitions",
        dryRun = false,
//        tags = "@account_activity",
        plugin = {"html:target/cucumber/report.html", "json:target/cucumber/report.json"}   // create the report
)


public class CukesRunner {

}