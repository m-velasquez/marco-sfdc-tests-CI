package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.opportunities.OpportunityDetail;
import org.example.sfdc.pages.opportunities.OpportunityForm;
import org.example.sfdc.pages.opportunities.OpportunityFormField;
import org.example.sfdc.pages.opportunities.OpportunityHome;

/**
 * Create steps for opportunities.
 */
public class OpportunitySteps {

    private final ScenarioContext context;

    /**
     * Constructor with Dependency Injection.
     *
     * @param context Helper.
     */
    public OpportunitySteps(final ScenarioContext context) {
        this.context = context;
    }

    /**
     * Fill the Opportunity Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Opportunity form with:$")
    public void iFillTheOpportunityFormWith(final Map<OpportunityFormField, String> formMapData) {
        context.setOpportunityName(formMapData.get(OpportunityFormField.OPPORTUNITY_NAME));
        context.setOpportunityMap(formMapData);
        new OpportunityForm().fillAndSaveForm(context.getOpportunityMap());
    }

    /**
     * Click on Edit inside Opportunity Detail.
     */
    @When("^I edit the Opportunity$")
    public void iEditTheOpportunity() {
        new OpportunityDetail().clickEditButton();
    }

    /**
     * Click on Delete button on Detail Page.
     */
    @When("^I Click on Delete from Opportunity")
    public void iClickOnDeleteFromOpportunity() {
        new OpportunityDetail().deleteItem();
    }

    /**
     * Click on New Opportunity special for a weird behavior.
     */
    @And("^I click on New Opportunity$")
    public void iClickOnNewOpportunity() {
        new OpportunityHome().clickNewButton();
    }

}
