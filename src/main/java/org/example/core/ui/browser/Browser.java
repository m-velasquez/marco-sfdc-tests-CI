package org.example.core.ui.browser;

import org.openqa.selenium.WebDriver;

/**
 * Interface for getting the current browser.
 */
@FunctionalInterface
public interface Browser {

    /**
     * Gets the WebDriver to use.
     *
     * @return WebDriver.
     */
    WebDriver getBrowser();
}
