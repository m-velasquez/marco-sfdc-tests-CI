package org.example.sfdc.pages.campaigns;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.sfdc.pages.base.DetailBase;
import org.example.sfdc.pages.base.FormBase;
import org.example.sfdc.pages.base.HomeBase;

/**
 * Class containing Campaign Detail Page.
 */
public class CampaignDetail extends DetailBase {

    @FindBy(xpath = "//p[contains(text(), 'Campaign')]/following-sibling::h1")
    private WebElement campaignNameText;

    /**
     * Gets the Campaign Name Text.
     *
     * @return String.
     */
    public String getCampaignNameText() {
        return campaignNameText.getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickEditButton() {
        action.clickElement(editButton);
        return new CampaignForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HomeBase deleteItem() {
        clickDeleteButton();
        clickConfirmDeleteButton();
        return new CampaignHome();
    }
}
