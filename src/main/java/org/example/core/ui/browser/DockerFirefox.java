package org.example.core.ui.browser;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.example.core.Env;

/**
 * DockerChromeBrowser class that implements IBrowsers.
 */
public class DockerFirefox extends Cloud {

    DockerFirefox() {
        super(Env.getInstance().getDockerUrl());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    MutableCapabilities buildCapabilities() {
        return new FirefoxOptions();
    }
}
