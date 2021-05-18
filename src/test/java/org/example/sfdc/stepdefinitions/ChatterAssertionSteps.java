package org.example.sfdc.stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.asserts.Assertion;

import org.example.sfdc.entities.ScenarioContext;
import org.example.sfdc.pages.chatter.PostForm;

/**
 * Chatter assert step definitions.
 */
public class ChatterAssertionSteps {

    private ScenarioContext context;

    private Assertion assertion;

    private PostForm postForm;

    /**
     * Constructor with Dependency Injection.
     *
     * @param context Helper.
     */
    public ChatterAssertionSteps(final ScenarioContext context) {
        this.context = context;
        this.assertion = context.getAssertion();
        postForm = new PostForm();
    }

    /**
     * The post edited should be displayed.
     *
     * @param message String.
     */
    @Then("^On the Chatter page should not display the \"([^\"]*)\"$")
    public void onTheChatterPageShouldNotDisplayThe(final String message) {
        assertion.assertFalse(postForm.isPostDisplayed(message));
    }

    /**
     * The comment for the Post should be displayed.
     */
    @Then("^On the Chatter page the comment should be displayed$")
    public void onTheChatterPageTheCommentShouldBeDisplayed() {
        assertion.assertTrue(postForm.isPostDisplayed(context.getCommentPostMessage()));
    }

    /**
     * The Chatter page should be displayed.
     */
    @Then("^On the Chatter page should be displayed$")
    public void onTheChatterPageShouldBeDisplayed() {
        assertion.assertTrue(postForm.isPostDisplayed(context.getPostMessage()));
    }

    /**
     * The Error message should be displayed.
     *
     * @param errorMessage this variable contains the error message.
     */
    @Then("^the message error \"([^\"]*)\" should be displayed$")
    public void onTheChatterPageTheMessageErrorShouldBeDisplayed(final String errorMessage) {
        assertion.assertTrue(postForm.isVisibleErrorMessage(errorMessage));

    }
}
