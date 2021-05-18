package org.example.sfdc.pages.campaigns;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.sfdc.pages.IStrategySteps;
import org.example.sfdc.pages.base.FormBase;

/**
 * Class containing Campaign Form Page.
 */
public class CampaignForm extends FormBase {

    @FindBy(xpath = "//span[contains(text(), 'Campaign Name')]/parent::label/following-sibling::input")
    private WebElement campaignNameInputText;

    /**
     * Set the campaign Name.
     *
     * @param campaignName String.
     */
    private void setCampaignNameInputText(final String campaignName) {
        if (action.isElementDisplayed(campaignNameInputText)) {
            action.setInputField(campaignNameInputText, campaignName);
        }
    }

    /**
     * {@inheritDoc}
     */
    public CampaignDetail fillAndSaveForm(final Map<CampaignFormField, String> formMapData) {
        formMapData.forEach((key, value) -> getStrategyMap(formMapData).get(key).performStep());
        clickSaveButton();
        return new CampaignDetail();
    }

    /**
     * Get the Strategy map.
     *
     * @param formMap Map.
     * @return Map.
     */
    private Map<CampaignFormField, IStrategySteps> getStrategyMap(final Map<CampaignFormField, String> formMap) {
        EnumMap<CampaignFormField, IStrategySteps> strategyMap = new EnumMap<>(CampaignFormField.class);
        strategyMap.put(CampaignFormField.CAMPAIGN_NAME,
                () -> setCampaignNameInputText(formMap.get(CampaignFormField.CAMPAIGN_NAME)));
        return strategyMap;
    }
}
