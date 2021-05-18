package org.example.sfdc.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.example.core.Env;
import org.example.core.ui.driver.SharedDriver;
import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.Navigator;
import org.example.sfdc.pages.SObject;
import org.example.sfdc.pages.acccounts.AccountFormField;
import org.example.sfdc.pages.campaigns.CampaignFormField;
import org.example.sfdc.pages.login.Login;
import org.example.sfdc.pages.opportunities.OpportunityFormField;
import org.example.sfdc.pages.products.ProductFormField;

/**
 * Common Steps for all features.
 */
public class CommonSteps {

    private final ScenarioContext context;

    public CommonSteps(final SharedDriver sharedDriver, final ScenarioContext context) {
        this.context = context;
    }

    @ParameterType(".*")
    public SObject sObject(final String sObject) {
        return SObject.valueOf(sObject.toUpperCase());
    }

    @DataTableType
    public AccountFormField accountMap(final String accountFormField) {
        return AccountFormField.valueOf(accountFormField.toUpperCase());
    }

    @DataTableType
    public CampaignFormField campaignMap(final String campaignFormField) {
        return CampaignFormField.valueOf(campaignFormField.toUpperCase());
    }

    @DataTableType
    public OpportunityFormField opportunityMap(final String opportunityFormField) {
        return OpportunityFormField.valueOf(opportunityFormField.toUpperCase());
    }

    @DataTableType
    public ProductFormField productMap(final String productFormField) {
        return ProductFormField.valueOf(productFormField.toUpperCase());
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String listOfStringListsType(final String cell) {
        return cell;
    }

    @Given("I log in as default user")
    public void iLogInAsUser() {
        Login.loginInitial(Env.getInstance().getUsername(), Env.getInstance().getPassword());
    }

    /**
     * Step to go to Item Home Page.
     *
     * @param sObject SObject.
     */
    @Given("I go to {sObject} Home Page")
    public void iGoToHomePage(final SObject sObject) {
        Navigator.gotoPage(sObject);
    }

    /**
     * Step to click on New Button.
     *
     * @param sObject SObject.
     */
    @And("I click on New {sObject}")
    public void iClickOnNew(final SObject sObject) {
        Navigator.mapActions(sObject).clickNewButton();
    }

    /**
     * Click on Edit Button.
     *
     * @param sObject SObject.
     */
    @When("I click on Edit {sObject}")
    public void iClickOnEditSObject(final SObject sObject) {
        Navigator.mapActions(sObject).clickEditButton(context.getItemName());
    }

    /**
     * Delete the selected Object.
     *
     * @param sObject SObject.
     */
    @And("I delete the {sObject}")
    public void iDeleteThe(final SObject sObject) {
        Navigator.mapActions(sObject).deleteElement(context.getItemName());
    }

    /**
     * Click on a specified item of the list.
     *
     * @param sObject SObject.
     */
    @And("I click on the {sObject} item")
    public void iClickOnTheItem(final SObject sObject) {
        Navigator.mapActions(sObject).clickItemList(context.getItemName());
    }

}
