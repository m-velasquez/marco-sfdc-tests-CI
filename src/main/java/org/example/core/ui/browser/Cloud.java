package org.example.core.ui.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.example.core.MyRuntimeException;

/**
 * This class abstracts and implements common methods of the navigators in the cloud.
 */
public abstract class Cloud implements Browser {

    private static final Logger LOGGER = LogManager.getLogger();
    private final String url;

    /**
     * This is the constructor.
     *
     * @param url This variable contains the url authentication.
     */
    protected Cloud(final String url) {
        this.url = url;
    }

    /**
     * This method sets the capabilities of the Cloud Browser.
     *
     * @return a Desired Capabilities instance.
     */
    abstract MutableCapabilities buildCapabilities();

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(url), buildCapabilities());
        } catch (MalformedURLException e) {
            LOGGER.error("Not instance driver");
            LOGGER.info(e);
            throw new MyRuntimeException("Not instance driver", e);
        }
        return driver;
    }
}
