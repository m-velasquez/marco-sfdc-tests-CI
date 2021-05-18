package org.example.core.ui.driver;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();

    private static final List<WebDriver> STORED_DRIVERS = new ArrayList<>();
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> STORED_DRIVERS.forEach(WebDriver::quit)));
    }

    /**
     * Constructor.
     */
    private DriverFactory() {
    }

    public static void addDriver(final WebDriver driver) {
        DRIVERS.set(driver);
        STORED_DRIVERS.add(driver);
    }

    /**
     * Get Driver instance.
     *
     * @return driver instance.
     */
    public static WebDriver getDriver() {
        return DRIVERS.get();
    }

}

