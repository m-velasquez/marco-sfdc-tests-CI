package org.example.sfdc.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

/**
 * Runner class for all tests.
 */
@CucumberOptions(
        plugin = {"pretty",
                "html:target/test-report",
                "json:target/test-report.json",
                "junit:target/test-report.xml"},
        features = {"src/test/resources/features"},
        glue = {"org.example"},
        tags = "@bvt"
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeTest()
    public void setUp() {
        System.setProperty("dataproviderthreadcount", "1");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
     * Close the browser.
     */
    @AfterTest
    public void closeBrowser() {

    }
}
