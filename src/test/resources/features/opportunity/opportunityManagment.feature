Feature: Negative Testing

  Background:
    Given I log in as default user
    And I go to Opportunity Home Page
    And I click on New Opportunity

  Scenario: I can't create a new Opportunity without fields required.
    When I fill the Opportunity form with:
      | OPPORTUNITY_NAME |  |
    Then message displayed "These required fields must be completed: Account Name, Close Date, Opportunity Name, Stage"
