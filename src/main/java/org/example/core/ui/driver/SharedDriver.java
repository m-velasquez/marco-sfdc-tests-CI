package org.example.core.ui.driver;

import org.example.core.Env;
import org.example.core.ui.browser.BrowserFactory;
import org.example.core.ui.browser.BrowserType;

import org.openqa.selenium.WebDriver;

public class SharedDriver {

    public SharedDriver() {
        WebDriver driverSession = DriverFactory.getDriver();
        if (driverSession == null) {
            WebDriver driver = BrowserFactory.getDriverManager(BrowserType
                    .valueOf(Env.getInstance().getBrowser().toUpperCase()));
            DriverFactory.addDriver(driver);
        }
    }

}
