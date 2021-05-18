package org.example.sfdc.pages;

import java.util.EnumMap;
import java.util.function.Supplier;

import org.example.core.ui.BasePage;
import org.example.core.ui.driver.DriverFactory;
import org.example.sfdc.pages.acccounts.AccountDetail;
import org.example.sfdc.pages.acccounts.AccountForm;
import org.example.sfdc.pages.acccounts.AccountHome;
import org.example.sfdc.pages.base.DetailBase;
import org.example.sfdc.pages.base.FormBase;
import org.example.sfdc.pages.base.HomeBase;
import org.example.sfdc.pages.campaigns.CampaignDetail;
import org.example.sfdc.pages.campaigns.CampaignForm;
import org.example.sfdc.pages.campaigns.CampaignHome;
import org.example.sfdc.pages.chatter.PostForm;
import org.example.sfdc.pages.opportunities.OpportunityDetail;
import org.example.sfdc.pages.opportunities.OpportunityForm;
import org.example.sfdc.pages.opportunities.OpportunityHome;
import org.example.sfdc.pages.products.ProductDetail;
import org.example.sfdc.pages.products.ProductForm;
import org.example.sfdc.pages.products.ProductHome;

/**
 * Final class Navigator to access the different pages.
 */
public final class Navigator {

    /**
     * Private Constructor.
     */
    private Navigator() {

    }

    /**
     * Click and returns an AppLauncher Instance.
     *
     * @return AppLauncher.
     */
    public static AppLauncher clickAppLauncher() {
        return new Home().clickAppLauncher();
    }

    /**
     * Go to Products Home Page.
     *
     * @return ProductHome.
     */
    public static ProductHome goToProductsHome() {
        if (!DriverFactory.getDriver().getCurrentUrl().contains("Product2/list")) {
            clickAppLauncher().clickProductsTextLink();
        }
        return new ProductHome();
    }

    /**
     * Go to Chatter Home Page.
     *
     * @return PostForm.
     */
    public static PostForm goToChatterHome() {
        if (!DriverFactory.getDriver().getCurrentUrl().contains("chatter")) {
            clickAppLauncher().clickChatterTextLink();
        }
        return new PostForm();
    }

    /**
     * Go to Opportunity Home Page.
     *
     * @return OpportunityHome.
     */
    public static OpportunityHome goToOpportunityHome() {
        if (!DriverFactory.getDriver().getCurrentUrl().contains("Opportunity/list")) {
            clickAppLauncher().clickOpportunityTextLink();
        }
        return new OpportunityHome();
    }

    /**
     * Go to Campaign Home Page.
     *
     * @return CampaignHome.
     */
    public static CampaignHome goToCampaignHome() {
        if (!DriverFactory.getDriver().getCurrentUrl().contains("Campaign/list")) {
            clickAppLauncher().clickCampaignTextLink();
        }
        return new CampaignHome();
    }

    /**
     * Go to Accounts Home Page.
     *
     * @return ProductHome.
     */
    public static AccountHome goToAccountsHome() {
        if (!DriverFactory.getDriver().getCurrentUrl().contains("Account/list")) {
            clickAppLauncher().clickAccountTextLink();
        }
        return new AccountHome();
    }

    /**
     * Static method to go to any page on Enum SObject.
     *
     * @param endPoint SObject.
     * @return HomeBase.
     */
    public static BasePage gotoPage(final SObject endPoint) {
        EnumMap<SObject, Supplier<BasePage>> map = new EnumMap<>(SObject.class);
        map.put(SObject.ACCOUNT, Navigator::goToAccountsHome);
        map.put(SObject.CHATTER, Navigator::goToChatterHome);
        map.put(SObject.OPPORTUNITY, Navigator::goToOpportunityHome);
        map.put(SObject.CAMPAIGN, Navigator::goToCampaignHome);
        map.put(SObject.PRODUCT, Navigator::goToProductsHome);
        return map.get(endPoint).get();
    }

    /**
     * Static method to map Actions.
     *
     * @param item SObject.
     * @return HomeBase.
     */
    public static HomeBase mapActions(final SObject item) {
        EnumMap<SObject, Supplier<HomeBase>> map = new EnumMap<>(SObject.class);
        map.put(SObject.PRODUCT, ProductHome::new);
        map.put(SObject.ACCOUNT, AccountHome::new);
        map.put(SObject.OPPORTUNITY, OpportunityHome::new);
        map.put(SObject.CAMPAIGN, CampaignHome::new);
        return map.get(item).get();
    }

    /**
     * Static method to return a specific Form page.
     *
     * @param item SObject.
     * @return FormBase.
     */
    public static FormBase mapForm(final SObject item) {
        EnumMap<SObject, Supplier<FormBase>> map = new EnumMap<>(SObject.class);
        map.put(SObject.PRODUCT, ProductForm::new);
        map.put(SObject.ACCOUNT, AccountForm::new);
        map.put(SObject.OPPORTUNITY, OpportunityForm::new);
        map.put(SObject.CAMPAIGN, CampaignForm::new);
        return map.get(item).get();
    }

    /**
     * Static method to return a specific Detail page.
     *
     * @param item SObject.
     * @return DetailBase.
     */
    public static DetailBase mapDetail(final SObject item) {
        EnumMap<SObject, Supplier<DetailBase>> map = new EnumMap<>(SObject.class);
        map.put(SObject.PRODUCT, ProductDetail::new);
        map.put(SObject.ACCOUNT, AccountDetail::new);
        map.put(SObject.OPPORTUNITY, OpportunityDetail::new);
        map.put(SObject.CAMPAIGN, CampaignDetail::new);
        return map.get(item).get();
    }
}
