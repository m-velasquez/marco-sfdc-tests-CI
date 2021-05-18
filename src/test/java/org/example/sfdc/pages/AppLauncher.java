package org.example.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.BasePage;
import org.example.sfdc.pages.acccounts.AccountHome;
import org.example.sfdc.pages.campaigns.CampaignHome;
import org.example.sfdc.pages.chatter.PostForm;
import org.example.sfdc.pages.opportunities.OpportunityHome;
import org.example.sfdc.pages.products.ProductHome;

/**
 * Class for the App Launcher.
 */
public class AppLauncher extends BasePage {

    @FindBy(css = "div one-app-launcher-menu")
    private WebElement windowModal;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Products']")
    private WebElement productsTextLink;

    @FindBy(xpath = "//one-app-launcher-menu/descendant::button")
    private WebElement openAllAppsButton;

    @FindBy(xpath = "//one-app-launcher-modal/descendant::a[contains(@href, 'Account')]")
    private WebElement accountsTextLink;

    @FindBy(xpath = "//one-app-launcher-modal/descendant::a[contains(@href, 'Opportunity')]")
    private WebElement opportunitiesTextLink;

    @FindBy(xpath = "//one-app-launcher-modal/descendant::a[contains(@href, 'Campaign')]")
    private WebElement campaignTextLink;

    @FindBy(xpath = "//one-app-launcher-modal/descendant::a[contains(@href, 'chatter')]")
    private WebElement chatterTextLink;

    @FindBy(css = "a[title='Opportunities']")
    private WebElement opportunityButton;

    /**
     * Waits for the modal is displayed.
     */
    private void waitModal() {
        action.waitFixedTime();
        action.isElementDisplayed(windowModal);
    }

    /**
     * Clicks the Product Text Link.
     *
     * @return ProductHome.
     */
    public ProductHome clickProductsTextLink() {
        waitModal();
        action.clickElement(openAllAppsButton);
        action.jsClick(productsTextLink);
        return new ProductHome();
    }

    /**
     * Clicks the Chatter Text Link.
     *
     * @return PostForm
     */
    public PostForm clickChatterTextLink() {
        waitModal();
        action.clickElement(openAllAppsButton);
        action.jsClick(chatterTextLink);
        return new PostForm();
    }

    /**
     * Clicks the Product Text Link.
     *
     * @return ProductHome.
     */
    public AccountHome clickAccountTextLink() {
        waitModal();
        action.clickElement(openAllAppsButton);
        action.jsClick(accountsTextLink);
        return new AccountHome();
    }

    /**
     * Clicks the Opportunity Text Link.
     *
     * @return OpportunityHome.
     */
    public OpportunityHome clickOpportunityTextLink() {
        waitModal();
        action.clickElement(openAllAppsButton);
        action.jsClick(opportunitiesTextLink);
        return new OpportunityHome();
    }

    /**
     * Clicks the Opportunity Button.
     *
     * @return OpportunityHome.
     */
    public OpportunityHome clickOpportunityButton() {
        action.clickElement(opportunityButton);
        return new OpportunityHome();
    }

    /**
     * Clicks the Campaign Text Link.
     *
     * @return CampaignHome.
     */
    public CampaignHome clickCampaignTextLink() {
        waitModal();
        action.clickElement(openAllAppsButton);
        action.jsClick(campaignTextLink);
        return new CampaignHome();
    }
}
