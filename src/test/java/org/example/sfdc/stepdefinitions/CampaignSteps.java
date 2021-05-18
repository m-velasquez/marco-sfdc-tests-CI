package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.When;

import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.campaigns.CampaignDetail;
import org.example.sfdc.pages.campaigns.CampaignForm;
import org.example.sfdc.pages.campaigns.CampaignFormField;

/**
 * Create steps for campaign.
 */
public class CampaignSteps {

    private ScenarioContext context;

    /**
     * Constructor with Dependency Injection.
     *
     * @param context Helper.
     */
    public CampaignSteps(final ScenarioContext context) {
        this.context = context;
    }

    /**
     * Fill the Campaign Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Campaign form with:$")
    public void iFillTheCampaignFormWith(final Map<CampaignFormField, String> formMapData) {
        context.setCampaignName(formMapData.get(CampaignFormField.CAMPAIGN_NAME));
        context.setCampaignMap(formMapData);
        new CampaignForm().fillAndSaveForm(context.getCampaignMap());
    }

    /**
     * Click on Edit inside Campaign Detail.
     */
    @When("^click on Edit Campaign $")
    public void iClickOnEditCampaign() {
        new CampaignDetail().clickEditButton();
    }

    /**
     * Click on Delete button on Detail Page.
     */
    @When("^I Click on Delete from Campaign")
    public void iClickOnDeleteFromCampaign() {
        new CampaignDetail().deleteItem();
    }
}
