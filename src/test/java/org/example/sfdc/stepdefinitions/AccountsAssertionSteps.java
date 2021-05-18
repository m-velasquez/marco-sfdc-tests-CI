package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.Assertion;

import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.acccounts.AccountDetail;
import org.example.sfdc.pages.acccounts.AccountFormField;
import org.example.sfdc.pages.acccounts.AccountHome;

/**
 * Account assert step definitions.
 */
public class AccountsAssertionSteps {

    private final Map<AccountFormField, String> map;

    private final Assertion assertion;

    /**
     * Constructor with Dependency Injection.
     *
     * @param context Helper.
     */
    public AccountsAssertionSteps(final ScenarioContext context) {
        this.map = context.getAccountMap();
        this.assertion = context.getAssertion();
    }

    /**
     * The Account data should be displayed on Account Detail Page.
     */
    @Then("^the Account should be displayed$")
    public void theAccountShouldBeDisplayed() {
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.clickDetailButton();
        assertion.assertEquals(accountDetail.getAccountNameText(), map.get(AccountFormField.ACCOUNT_NAME));
        assertion.assertEquals(accountDetail.getWebsiteText(), map.get(AccountFormField.ACCOUNT_WEBSITE));
        assertion.assertEquals(accountDetail.getDescriptionText(), map.get(AccountFormField.ACCOUNT_DESCRIPTION));
        assertion.assertEquals(accountDetail.getPhoneText(), map.get(AccountFormField.ACCOUNT_PHONE));
        assertion.assertEquals(accountDetail.getEmployeesText(), map.get(AccountFormField.ACCOUNT_EMPLOYEES));
    }

    /**
     * The Account Data should be displayed on Account Home Page.
     */
    @And("^the Account should be displayed on Home Page$")
    public void theAccountShouldBeDisplayedOnHomePage() {
        AccountHome accountHome = new AccountHome();
        assertion.assertTrue(accountHome.isDisplayedItem(map.get(AccountFormField.ACCOUNT_NAME)),
                String.format("%s is not displayed", AccountFormField.ACCOUNT_NAME));
        assertion.assertTrue(accountHome.isAccountFieldDisplayed(map.get(AccountFormField.ACCOUNT_NAME),
                map.get(AccountFormField.ACCOUNT_PHONE)),
                String.format("%s %s is not displayed", AccountFormField.ACCOUNT_NAME, AccountFormField.ACCOUNT_PHONE));
    }

    /**
     * The Account should not be displayed on Home Page.
     */
    @Then("^the Account should not be displayed on Home Page$")
    public void theAccountShouldNotBeDisplayedOnHomePage() {
        AccountHome accountHome = new AccountHome();
        assertion.assertFalse(accountHome.isDisplayedItem(map.get(AccountFormField.ACCOUNT_NAME)));
    }
}
