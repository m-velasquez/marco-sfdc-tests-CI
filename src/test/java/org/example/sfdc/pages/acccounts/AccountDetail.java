package org.example.sfdc.pages.acccounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.sfdc.pages.base.DetailBase;

/**
 * Class containing Product Detail Page.
 */
public class AccountDetail extends DetailBase {

    //Details
    @FindBy(xpath = "//span[text()='Account Name']/parent::div/following-sibling::div/descendant::lightning-formatted-text")
    private WebElement accountNameLabel;

    @FindBy(xpath = "//span[text()='Type']/parent::div/following-sibling::div/descendant::lightning-formatted-text")
    private WebElement typeLabel;

    @FindBy(xpath = "//span[text()='Website']/parent::div/following-sibling::div/descendant::lightning-formatted-url")
    private WebElement websiteLabel;

    @FindBy(xpath = "//span[text()='Description']/parent::div/following-sibling::div/descendant::lightning-formatted-text")
    private WebElement descriptionLabel;

    @FindBy(xpath = "//span[text()='Phone']/parent::div/following-sibling::div/descendant::lightning-formatted-phone")
    private WebElement phoneLabel;

    @FindBy(xpath = "//span[text()='Industry']/parent::div/following-sibling::div/descendant::lightning-formatted-text")
    private WebElement industryLabel;

    @FindBy(xpath = "//span[text()='Employees']/parent::div/following-sibling::div/descendant::lightning-formatted-number")
    private WebElement employeesLabel;

    //Address Information.
    @FindBy(xpath = "//span[text()='Billing Address']/parent::div/following-sibling::div/descendant::lightning-formatted-address")
    private WebElement billingAddressTextLink;

    @FindBy(xpath = "//span[text()='Shipping Address']/parent::div/following-sibling::div/descendant::lightning-formatted-address")
    private WebElement shippingAddressTextLink;

    //Show Details
    @FindBy(xpath = "//button[@title='Edit Shipping Address']")
    private WebElement editShippingAddress;

    @FindBy(xpath = "//button[@title='Edit Billing Address']")
    private WebElement editBillingAddress;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountForm clickEditButton() {
        action.clickElement(editButton);
        return new AccountForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountHome deleteItem() {
        clickDeleteButton();
        clickConfirmDeleteButton();
        return new AccountHome();
    }

    /**
     * Gets the Account Name Text.
     *
     * @return String.
     */
    public String getAccountNameText() {
        return action.getTextElement(accountNameLabel);
    }

    /**
     * Gets the Type Text.
     *
     * @return String.
     */
    public String getTypeText() {
        return action.getTextElement(typeLabel);
    }

    /**
     * Gets the Website Text.
     *
     * @return String.
     */
    public String getWebsiteText() {
        return action.getTextElement(websiteLabel);
    }

    /**
     * Gets the Description Text.
     *
     * @return String.
     */
    public String getDescriptionText() {
        return action.getTextElement(descriptionLabel);
    }

    /**
     * Gets the Phone Text.
     *
     * @return String.
     */
    public String getPhoneText() {
        return action.getTextElement(phoneLabel);
    }

    /**
     * Gets the Industry Text.
     *
     * @return String.
     */
    public String getIndustryText() {
        return action.getTextElement(industryLabel);
    }

    /**
     * Gets the Employees Text.
     *
     * @return String.
     */
    public String getEmployeesText() {
        return action.getTextElement(employeesLabel);
    }

    /**
     * Gets the Billing Address Text.
     *
     * @return String.
     */
    public String getBillingAddressText() {
        return action.getTextElement(billingAddressTextLink);
    }

    /**
     * Gets the ShippingAddress Text.
     *
     * @return String.
     */
    public String getShippingAddressText() {
        return action.getTextElement(shippingAddressTextLink);
    }

    /**
     * Click Edit Shipping Address.
     */
    public void clickEditShippingAddress() {
        action.clickElement(editShippingAddress);
    }

    /**
     * Click Edit Billing Address.
     */
    public void clickEditBillingAddress() {
        action.clickElement(editBillingAddress);
    }

}
