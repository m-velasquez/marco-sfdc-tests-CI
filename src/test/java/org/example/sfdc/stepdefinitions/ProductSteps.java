package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.When;

import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.products.ProductDetail;
import org.example.sfdc.pages.products.ProductForm;
import org.example.sfdc.pages.products.ProductFormField;
import org.example.sfdc.pages.products.ProductHome;

/**
 * Create Steps for Products.
 */
public class ProductSteps {

    private ScenarioContext context;

    /**
     * Constructor with Dependency Injection.
     *
     * @param context Helper.
     */
    public ProductSteps(final ScenarioContext context) {
        this.context = context;
    }

    /**
     * Fill the Product Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Product form with:$")
    public void iFillTheProductFormWith(final Map<ProductFormField, String> formMapData) {
        context.setItemName(formMapData.get(ProductFormField.PRODUCT_NAME));
        context.setProductMap(formMapData);
        new ProductForm().fillAndSaveForm(context.getProductMap());
        new ProductHome().waitUntilSpinnerIsHidden();

    }

    /**
     * Click on Edit inside Product Detail.
     */
    @When("^I click on Edit from Product$")
    public void iClickOnEditFromProduct() {
        new ProductDetail().clickEditButton();
    }

    /**
     * Click on Delete button on Detail Page.
     */
    @When("^I click on Delete from Product$")
    public void iClickOnDeleteFromProduct() {
        new ProductDetail().deleteItem();
    }
}
