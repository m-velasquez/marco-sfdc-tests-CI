package org.example.sfdc.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.Navigator;
import org.example.sfdc.pages.SObject;
import org.example.sfdc.pages.acccounts.AccountForm;

/**
 * Common assert step definitions.
 */
public class CommonAssertionSteps {

    private ScenarioContext context;

    private Assertion assertion;

    /**
     * Constructor with Dependency Injection.
     *
     * @param context Helper.
     */
    public CommonAssertionSteps(final ScenarioContext context) {
        this.context = context;
        assertion = this.context.getAssertion();
    }

    /**
     * This method executes all soft asserts.
     */
    @And("^Assert all$")
    public void assertAll() {
        if (assertion instanceof SoftAssert) {
            ((SoftAssert) assertion).assertAll();
        }
    }

    /**
     * Assertion step to verify the error message displayed.
     *
     * @param msg     error message that should be displayed in a Form Page.
     * @param sObject SObject enum parameter.
     */
    @Then("{string} message should be displayed in {sObject} form")
    public void messageShouldBeDisplayedInForm(final String msg, final SObject sObject) {
        assertion.assertTrue(Navigator.mapForm(sObject).errorNotificationText().contains(msg));
        AccountForm accountForm = new AccountForm();
        accountForm.clickCancelButton();
    }

    /**
     * Assertion step to verify the success message displayed in a Home page.
     *
     * @param msg     error message displayed.
     * @param sObject SObject enum parameter.
     */
    @Then("{string} message should be displayed in {sObject} Home Page")
    public void messageShouldBeDisplayedInHomePage(final String msg, final SObject sObject) {
        final String msgExpected = context.rebuiltMessage(msg);
        assertion.assertTrue(Navigator.mapActions(sObject).successMessageText().contains(msgExpected));
    }

    /**
     * Assertion step to verify the success message displayed in a Detail Page.
     *
     * @param msg     error message displayed.
     * @param sObject SObject enum parameter.
     */
    @Then("{string} message should be displayed in {sObject} Detail Page")
    public void messageShouldBeDisplayedInDetailPage(final String msg, final SObject sObject) {
        final String msgExpected = context.rebuiltMessage(msg);
        assertion.assertEquals(Navigator.mapDetail(sObject).successMessageText(), msgExpected);
    }
}
