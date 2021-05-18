package org.example.core.ui.browser;

import java.util.EnumMap;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

/**
 * Driver Factory class that gets the browser.
 */
public final class BrowserFactory {

    private static final EnumMap<BrowserType, Supplier<Browser>> BROWSERS = new EnumMap<>(BrowserType.class);
    static {
        BROWSERS.put(BrowserType.CHROME, Chrome::new);
        BROWSERS.put(BrowserType.FIREFOX, Firefox::new);
        BROWSERS.put(BrowserType.HEADLESS, Headless::new);
        BROWSERS.put(BrowserType.SAUCELABS, SauceLabs::new);
        BROWSERS.put(BrowserType.BROWSERSTACK, BrowserStack::new);
        BROWSERS.put(BrowserType.DOCKER_CHROME, DockerChrome::new);
        BROWSERS.put(BrowserType.DOCKER_FIREFOX, DockerFirefox::new);
    }

    /**
     * Private Constructor.
     */
    private BrowserFactory() {
    }

    /**
     * Return current Driver.
     *
     * @param browserType Enum from BrowserType.
     * @return Current WebDriver.
     */
    public static WebDriver getDriverManager(final BrowserType browserType) {
        return BROWSERS.get(browserType).get().getBrowser();
    }
}
