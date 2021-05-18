Feature: Create Opportunity

  Background: Create Campaign
    Given I log in as default user
    And I go to Account Home Page
    And I click on New Account
    And I fill the Account form with:
      | ACCOUNT_NAME | account |
    And I go to Campaign Home Page
    And I click on New Campaign
    And I fill the Campaign form with:
      | CAMPAIGN_NAME | campaign |
    And I go to Opportunity Home Page

  @bvt @deleteCampaign @deleteAccount
  Scenario: Create a new Opportunity
    When I click on New Opportunity
    And I fill the Opportunity form with:
      | OPPORTUNITY_NAME        | Opportunity       |
      | OPPORTUNITY_ACCOUNT     | account           |
      | DATE                    | Today             |
      | OPPORTUNITY_STAGE       | Proposal          |
      | OPPORTUNITY_TYPE        | New Customer      |
      | OPPORTUNITY_CAMPAIGN    | campaign          |
      | OPPORTUNITY_AMOUNT      | 70                |
      | OPPORTUNITY_LEAD        | Advertisement     |
      | OPPORTUNITY_NEXT        | step              |
      | OPPORTUNITY_DESCRIPTION | description       |
    Then the Opportunity should be displayed
    And I go to Opportunity Home Page
    And the Opportunity should be displayed on Home Page
