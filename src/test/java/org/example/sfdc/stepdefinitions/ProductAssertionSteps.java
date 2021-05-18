package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.Assertion;

import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.products.ProductDetail;
import org.example.sfdc.pages.products.ProductFormField;
import org.example.sfdc.pages.products.ProductHome;

/**
 * Opportunity step definitions.
 */
public class ProductAssertionSteps {

    private ScenarioContext context;

    private Map<ProductFormField, String> map;

    private Assertion assertion;

    /**
     * Constructor with Dependency Injection.
     *
     * @param context Helper.
     */
    public ProductAssertionSteps(final ScenarioContext context) {
        this.context = context;
        this.map = this.context.getProductMap();
        this.assertion = context.getAssertion();
    }

    /**
     * The Product data should be displayed on Product Detail Page.
     */
    @Then("^the Product should be displayed$")
    public void theProductShouldBeDisplayed() {
        ProductDetail productDetail = new ProductDetail();
        productDetail.waitObjectNameIs(context.getItemName());
        productDetail.waitUntilSuccessMessage();
        assertion.assertTrue(productDetail.getProductNameText()
                .equals(map.get(ProductFormField.PRODUCT_NAME)));
        assertion.assertTrue(productDetail.getProductCodeText()
                .equals(map.get(ProductFormField.PRODUCT_CODE)));
        assertion.assertTrue(productDetail.getProductDescriptionText()
                .equals(map.get(ProductFormField.PRODUCT_DESCRIPTION)));
        assertion.assertTrue(productDetail.getProductFamilyText()
                .equals(map.get(ProductFormField.PRODUCT_FAMILY)));
    }

    /**
     * The Product Data should be displayed on Product Home Page.
     */
    @And("^the Product should be displayed on Home Page$")
    public void theProductShouldBeDisplayedOnHomePage() {
        ProductHome productHome = new ProductHome();
        productHome.waitUntilSpinnerIsHidden();
        assertion.assertTrue(productHome
                .isDisplayedItem(map.get(ProductFormField.PRODUCT_NAME)));
        assertion.assertTrue(productHome.isProductFieldDisplayed(
                map.get(ProductFormField.PRODUCT_NAME),
                map.get(ProductFormField.PRODUCT_CODE)));
        assertion.assertTrue(productHome.isProductFieldDisplayed(
                map.get(ProductFormField.PRODUCT_NAME),
                map.get(ProductFormField.PRODUCT_DESCRIPTION)));
        assertion.assertTrue(productHome.isProductFieldDisplayed(
                map.get(ProductFormField.PRODUCT_NAME),
                map.get(ProductFormField.PRODUCT_FAMILY)));
    }

    /**
     * The Product shouldn't be displayed on Home Page After Delete.
     */
    @Then("^the Product should not be displayed on Home Page$")
    public void theProductShouldNotBeDisplayedOnHomePage() {
        ProductHome productHome = new ProductHome();
        assertion.assertFalse(productHome.isDisplayedItem(map.get(ProductFormField.PRODUCT_NAME)));
    }
}
