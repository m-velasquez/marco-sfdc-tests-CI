package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.Assertion;

import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.campaigns.CampaignDetail;
import org.example.sfdc.pages.campaigns.CampaignFormField;
import org.example.sfdc.pages.campaigns.CampaignHome;

/**
 * Campaign assert step definitions.
 */
public class CampaignAssertionSteps {

    private final ScenarioContext context;

    private final Map<CampaignFormField, String> map;

    private final Assertion assertion;

    /**
     * Constructor with Dependency Injection.
     *
     * @param context Helper.
     */
    public CampaignAssertionSteps(final ScenarioContext context) {
        this.context = context;
        this.map = context.getCampaignMap();
        this.assertion = context.getAssertion();
    }

    /**
     * The Campaign data should be displayed on Campaign Detail Page.
     */
    @Then("^the Campaign should be displayed$")
    public void theCampaignShouldBeDisplayed() {
        CampaignDetail campaignDetail = new CampaignDetail();
        campaignDetail.waitObjectNameIs(context.getCampaignName());
        assertion.assertTrue(campaignDetail.getCampaignNameText().equals(map.get(CampaignFormField.CAMPAIGN_NAME)));
    }

    /**
     * The Campaign Data should be displayed on Campaign Home Page.
     */
    @And("^the Campaign should be displayed on Home Page$")
    public void theCampaignShouldBeDisplayedOnHomePage() {
        CampaignHome campaignHome = new CampaignHome();
        assertion.assertTrue(campaignHome.isDisplayedItem(map.get(CampaignFormField.CAMPAIGN_NAME)));

    }

    /**
     * The Campaign shouldn't be displayed on Home Page After Delete.
     */
    @Then("^the Campaign should not be displayed on Home Page$")
    public void theCampaignShouldNotBeDisplayedOnHomePage() {
        CampaignHome campaignHome = new CampaignHome();
        assertion.assertFalse(campaignHome.isDisplayedItem(map.get(CampaignFormField.CAMPAIGN_NAME)));
    }
}
