package org.example.core.ui;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.example.core.Env;

/**
 * Class containing the common actions for the framework.
 */
public class WebdriverAction {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String JS_SCRIPT = "document.querySelector(\"a[title='%s']\").click();";

    private final WebDriver driver;

    private final WebDriverWait wait;

    public WebdriverAction(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * This method waits and clear the WebElement.
     *
     * @param webElement WebElement to wait and clear.
     */
    public void clearTextField(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement)).clear();
    }

    /**
     * This method set a Input Field.
     *
     * @param webElement WebElement to wait and fill.
     * @param text       Text to fill.
     */
    public void setInputField(final WebElement webElement, final String text) {
        clearTextField(webElement);
        webElement.sendKeys(text);
    }

    /**
     * This method waits and click on the webElement.
     *
     * @param webElement WebElement to wait and click.
     */
    public void clickElement(final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    /**
     * This method waits and get the text of an WebElement.
     *
     * @param webElement WebElement to wait and get the text.
     * @return Text of element.
     */
    public String getTextElement(final WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement)).getText();
    }

    /**
     * This method verify that Web element is Displayed.
     *
     * @param webElement WebElement.
     * @return True if the element is Displayed.
     */
    public boolean isElementDisplayed(final WebElement webElement) {
        return  wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
    }

    /**
     * Check if the element is selected.
     *
     * @param element WebElement.
     * @return boolean.
     */
    public boolean isElementSelected(final WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).isSelected();
    }

    /**
     * Set Check Box status.
     *
     * @param element WebElement.
     * @param flag    boolean.
     */
    public void setCheckBox(final WebElement element, boolean flag) {
        if (!isElementSelected(element) && flag) {
            clickElement(element);
        }
    }

    /**
     * This method generates a wait for a fixed time, uses the driver manager to generate
     * a explicit wait for a web element that does not exist.
     */
    public void waitFixedTime() {
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            wait.withTimeout(Duration.ofSeconds(3));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Just For Wait']")));
        } catch (TimeoutException e) {
            LOGGER.error("Timeout exception triggered");
        } finally {
            driver.manage().timeouts().implicitlyWait(Env.getInstance().getImplicitTimeWait(), TimeUnit.SECONDS);
            wait.withTimeout(Duration.ofSeconds(Env.getInstance().getExplicitTimeWait()));
        }
    }

    /**
     * This method perform a search in a WebElement list based on a content string parameter.
     *
     * @param elements is the WebElements lists.
     * @param content  is the content parameter.
     * @return the WebElement search result.
     */
    public WebElement findWebElement(final List<WebElement> elements, final String content) {
        return elements.stream()
                .filter(element -> content.contains(element.getText()))
                .findAny()
                .orElseThrow();
    }

    /**
     * This method perform a click in a non visible element in the UI using css locator.
     *
     * @param webElement the WebElement non visible in the UI.
     */
    public void jsClickCssButton(final WebElement webElement) {
        ((JavascriptExecutor) driver)
                .executeScript(String.format(JS_SCRIPT, webElement.getAttribute("title")));
    }

    /**
     * This method perform a click in a non visible element in the UI using class locator.
     *
     * @param webElement the WebElement non visible in the UI.
     */
    public void jsClick(final WebElement webElement) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", webElement);
    }

    public void mouseClick(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        new Actions(driver).moveToElement(element).click().perform();
    }
}
