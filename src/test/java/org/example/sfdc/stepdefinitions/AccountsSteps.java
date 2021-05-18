package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.When;

import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.acccounts.AccountDetail;
import org.example.sfdc.pages.acccounts.AccountForm;
import org.example.sfdc.pages.acccounts.AccountFormField;
import org.example.sfdc.pages.acccounts.AccountHome;

/**
 * Create Steps for Accounts.
 */
public class AccountsSteps {

    private ScenarioContext context;

    /**
     * Constructor with Dependency Injection.
     *
     * @param context Helper.
     */
    public AccountsSteps(final ScenarioContext context) {
        this.context = context;
    }

    /**
     * Fill the Account Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Account form with:$")
    public void iFillTheAccountFormWith(final Map<AccountFormField, String> formMapData) {
        context.setItemName(formMapData.get(AccountFormField.ACCOUNT_NAME));
        context.setAccountMap(formMapData);
        new AccountForm().fillAndSaveForm(context.getAccountMap());
        new AccountHome().waitUntilSpinnerIsHidden();
    }

    /**
     * Click on Edit from Account.
     */
    @When("^I edit the Account$")
    public void iEditTheAccount() {
        new AccountDetail().clickEditButton();
    }

    /**
     * Click on Delete from Account.
     */
    @When("^I Click on Delete from Account$")
    public void iClickOnDeleteFromAccount() {
        new AccountDetail().deleteItem();
    }
}
