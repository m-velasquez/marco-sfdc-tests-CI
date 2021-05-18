package org.example.sfdc.pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.BasePage;

/**
 * Abstract class that gets common info in Form Page.
 */
public abstract class FormBase extends BasePage {

    @FindBy(xpath = "//button[@name='SaveEdit']")
    protected WebElement saveButton;

    @FindBy(css = "button[title='Save & New']")
    protected WebElement saveAndNewButton;

    @FindBy(css = "button[title='Cancel']")
    protected WebElement cancelButton;

    @FindBy(xpath = "//ul[@class='errorsList']/child::li")
    protected WebElement requiredFieldsText;

    @FindBy(xpath = "//button[contains(@class, 'slds-button slds-modal__close closeIcon ')]")
    protected WebElement closeButton;

    /**
     * Clicks the Save Button of the Form.
     */
    public void clickSaveButton() {
        action.clickElement(saveButton);
    }

    /**
     * Clicks the close form button.
     */
    public void clickCloseButton() {
        action.clickElement(closeButton);
    }

    /**
     * Clicks the Save and New Button of the Form.
     */
    public void clickSaveAndNewButton() {
        action.clickElement(saveAndNewButton);
    }

    /**
     * Clicks the Cancel Button of the Form.
     */
    public void clickCancelButton() {
        action.clickElement(cancelButton);
    }

    /**
     * Return the complete text of the error notification.
     *
     * @return error notification content.
     */
    public String errorNotificationText() {
        return action.getTextElement(requiredFieldsText);
    }
}
