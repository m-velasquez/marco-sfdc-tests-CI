package org.example.core.ui.browser;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import org.example.core.Env;

/**
 * DockerChromeBrowser class that implements IBrowsers.
 */
public class DockerChrome extends Cloud {

    DockerChrome() {
        super(Env.getInstance().getDockerUrl());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    MutableCapabilities buildCapabilities() {
        return new ChromeOptions();
    }
}
