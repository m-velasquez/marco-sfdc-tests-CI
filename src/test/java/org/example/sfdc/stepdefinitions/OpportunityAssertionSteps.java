package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.Assertion;

import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.opportunities.OpportunityDetail;
import org.example.sfdc.pages.opportunities.OpportunityForm;
import org.example.sfdc.pages.opportunities.OpportunityFormField;
import org.example.sfdc.pages.opportunities.OpportunityHome;

/**
 * Opportunity step definitions.
 */
public class OpportunityAssertionSteps {

    private final Map<OpportunityFormField, String> map;

    private final Assertion assertion;

    /**
     * Constructor with Dependency Injection.
     *
     * @param context Helper.
     */
    public OpportunityAssertionSteps(final ScenarioContext context) {
        this.map = context.getOpportunityMap();
        assertion = context.getAssertion();
    }

    /**
     * The Opportunity data should be displayed on Opportunity Detail Page.
     */
    @Then("^the Opportunity should be displayed$")
    public void theOpportunityShouldBeDisplayed() {
        OpportunityDetail opportunityDetail = new OpportunityDetail();
        opportunityDetail.clickDetailButton();
        assertion.assertEquals(opportunityDetail.getOpportunityNameText(), map.get(OpportunityFormField.OPPORTUNITY_NAME));
        assertion.assertEquals(opportunityDetail.getOpportunityAccountText(), map.get(OpportunityFormField.OPPORTUNITY_ACCOUNT));
    }

    /**
     * The Opportunity Data should be displayed on Opportunity Home Page.
     */
    @And("^the Opportunity should be displayed on Home Page$")
    public void theOpportunityShouldBeDisplayedOnHomePage() {
        OpportunityHome opportunityHome = new OpportunityHome();
        assertion.assertTrue(opportunityHome.isDisplayedItem(
                map.get(OpportunityFormField.OPPORTUNITY_NAME)));
        assertion.assertTrue(opportunityHome.isOpportunityLinkDisplayed(
                map.get(OpportunityFormField.OPPORTUNITY_NAME),
                map.get(OpportunityFormField.OPPORTUNITY_ACCOUNT)));
    }

    /**
     * The Product shouldn't be displayed on Home Page After Delete.
     */
    @Then("^the Opportunity should not be displayed on Home Page$")
    public void theOpportunityShouldNotBeDisplayedOnHomePage() {
        OpportunityHome opportunityHome = new OpportunityHome();
        assertion.assertFalse(opportunityHome.isDisplayedItem(
                map.get(OpportunityFormField.OPPORTUNITY_NAME)));
    }

    /**
     * This method verify if message is displayed.
     *
     * @param errorMessage is message error.
     */
    @Then("^message displayed \"([^\"]*)\"$")
    public void theOpportunityShouldBeMessageDisplayed(final String errorMessage) {
        OpportunityForm opportunityForm = new OpportunityForm();
        assertion.assertTrue(opportunityForm.messageIsDisplayed(errorMessage));
    }

    /**
     * This method verify if message is displayed.
     *
     * @param error is message error.
     */
    @Then("^message displayed when field is invalid \"([^\"]*)\"$")
    public void messageDisplayedWhenFieldIsInvalid(final String error) {
        OpportunityForm opportunityForm = new OpportunityForm();
        assertion.assertTrue(opportunityForm.messageFieldInvalidIsDisplayed(error));
    }
}
