package org.example.sfdc.pages.login;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.Env;
import org.example.core.ui.BasePage;
import org.example.sfdc.pages.Home;
import org.example.sfdc.pages.Profile;

/**
 * Class for the login page.
 */
public class Login extends BasePage {

    private static final String URL = Env.getInstance().getLoginUrl();

    private static final Logger LOGGER = LogManager.getLogger();

    //All WebElements are identified by @FindBy annotation.
    @FindBy(id = "username")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    /**
     * Constructor for Default.
     */
    public Login() {
        loadUrlPage(URL);
    }

    /**
     * Set user name in input field.
     *
     * @param username User Name for Sales Force.
     * @return Login pageObject.
     */
    public Login setUserName(final String username) {
        action.setInputField(userNameInputField, username);
        return this;
    }

    /**
     * Set password in password input field.
     *
     * @param password Password for Sales Force.
     * @return Login pageObject.
     */
    public Login setPassword(final String password) {
        action.setInputField(passwordInputField, password);
        return this;
    }

    /**
     * This method make click on login button.
     *
     * @return Home pageObject.
     */
    public Home clickLogin() {
        action.clickElement(loginBtn);
        return new Home();
    }

    /**
     * This Method make a login to Salesforce application.
     *
     * @param username User Name for Sales Force.
     * @param password Password for Sales Force.
     * @return Home page after login to Salesforce application.
     */
    public Home loginAs(final String username, final String password) {
        return setUserName(username).setPassword(password).clickLogin();
    }

    /**
     * This Method make a login with other user to Salesforce application.
     *
     * @param userName User Name for Sales Force with other user.
     * @param password Password for Sales Force with other user.
     * @return Home page after login to Salesforce application.
     */
    public Home loginOtherUser(final String userName, final String password) {
        Home homePage;
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            wait.withTimeout(Duration.ofSeconds(3));
            homePage = verifyCorrectUser(userName, password);
            homePage.clickHomeLink();
        } catch (WebDriverException e) {
            LOGGER.error("WebDriverException");
            LOGGER.info(e);
            driver.get(URL);
            homePage = loginAs(userName, password);
        } finally {
            driver.manage().timeouts().implicitlyWait(Env.getInstance().getImplicitTimeWait(), TimeUnit.SECONDS);
            wait.withTimeout(Duration.ofSeconds(Env.getInstance().getExplicitTimeWait()));
        }
        return homePage;
    }

    /**
     * This method logs in if we are not in the correct session.
     *
     * @param userName User Name for Sales Force with other user.
     * @param password Password for Sales Force with other user.
     * @return Home page after login with correct session.
     */
    private Home verifyCorrectUser(final String userName, final String password) {
        final Home homePage = new Home();
        Profile profile = homePage.clickProfileLinkLabel();
        if (!profile.isCorrectUserLogged(userName)) {
            homePage.clickLogOutLink();
            loginAs(userName, password);
        }
        return homePage;
    }

    /**
     * This method verify is the user is logged.
     *
     * @return True if the user is logged.
     */
    public boolean isUserLogged() {
        return getCurrentUrl().contains(".lightning.force.com");

    }

    /**
     * This method make a login Initial.
     *
     * @param userName User Name for Sales Force with other user.
     * @param password Password for Sales Force with other user.
     * @return Home page after login to Salesforce application.
     */
    public static Home loginInitial(final String userName, final String password) {
        Login login = new Login();
        return login.isUserLogged() ? login.loginOtherUser(userName, password) : login.loginAs(userName, password);
    }
}
