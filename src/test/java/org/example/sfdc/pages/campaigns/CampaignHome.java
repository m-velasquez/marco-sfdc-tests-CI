package org.example.sfdc.pages.campaigns;

import org.openqa.selenium.By;

import org.example.sfdc.pages.base.DetailBase;
import org.example.sfdc.pages.base.FormBase;
import org.example.sfdc.pages.base.HomeBase;

/**
 * Class containing Campaign Home Page.
 */
public class CampaignHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickNewButton() {
        action.waitFixedTime();
        action.jsClickCssButton(newButton);
        return new CampaignForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickEditButton(final String name) {
        clickDropDownListLink(name);
        action.clickElement(editButton);
        return new CampaignForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetailBase clickDisplayedItem(final String name) {
        isDisplayedItem(name);
        action.clickElement(displayedItem);
        return new CampaignDetail();
    }

    /**
     * Determines if the Product Field Data is displayed on Home Page.
     *
     * @param campaignName  Product Name for row.
     * @param campaignField Product Field like Code, Family.
     * @return boolean.
     */
    public boolean isCampaignFieldDisplayed(final String campaignName, final String campaignField) {
        String xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::span[text()='%s']",
                campaignName, campaignField);
        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }
}
