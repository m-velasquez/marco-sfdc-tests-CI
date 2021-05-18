package org.example.sfdc.pages.opportunities;

import org.openqa.selenium.By;

import org.example.sfdc.pages.base.DetailBase;
import org.example.sfdc.pages.base.FormBase;
import org.example.sfdc.pages.base.HomeBase;

/**
 * Class containing Opportunity Home Page.
 */
public class OpportunityHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickNewButton() {
        action.waitFixedTime();
        action.jsClick(newButton);
        return new OpportunityForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickEditButton(final String name) {
        clickDropDownListLink(name);
        action.clickElement(editButton);
        return new OpportunityForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetailBase clickDisplayedItem(final String name) {
        isDisplayedItem(name);
        action.clickElement(displayedItem);
        return new OpportunityDetail();
    }

    /**
     * Determines if the Opportunity Field Data is displayed on Home Page.
     *
     * @param opportunityName  Opportunity Name for row.
     * @param opportunityField Opportunity Field like Code, Family.
     * @return boolean.
     */
    public boolean isOpportunityFieldDisplayed(final String opportunityName, final String opportunityField) {
        String xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::span[text()='%s']",
                opportunityName, opportunityField);
        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }

    /**
     * @param opportunityName  field.
     * @param opportunityField field.
     * @return driver.
     */
    public boolean isOpportunityLinkDisplayed(final String opportunityName, final String opportunityField) {
        String xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::a[text()='%s']",
                opportunityName, opportunityField);
        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }
}
