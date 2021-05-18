Feature: Edit Opportunity

  Background:
    Given I log in as default user
    And I go to Account Home Page
    And I click on New Account
    And I fill the Account form with:
      | ACCOUNT_NAME | account |
    And I go to Opportunity Home Page
    And I click on New Opportunity
    And I fill the Opportunity form with:
      | OPPORTUNITY_NAME     | Opportunity      |
      | OPPORTUNITY_ACCOUNT  | ${ACCOUNT_NAME}  |
      | DATE                 | 13/08/2017       |
      | OPPORTUNITY_STAGE    | Proposal         |

  @bvt @deleteAccount
  Scenario: Edit the Opportunity on Detail Page
    When I edit the Opportunity
    And I fill the Opportunity form with:
      | OPPORTUNITY_NAME        | OpportunityEdit   |
      | OPPORTUNITY_ACCOUNT     | ${ACCOUNT_NAME}   |
      | DATE                    | Today             |
      | OPPORTUNITY_TYPE        | New Customer      |
      | OPPORTUNITY_AMOUNT      | 70                |
      | OPPORTUNITY_LEAD        | Advertisement     |
      | OPPORTUNITY_NEXT        | step              |
      | OPPORTUNITY_DESCRIPTION | description       |
    Then the Opportunity should be displayed
    And I go to Opportunity Home Page
    And the Opportunity should be displayed on Home Page

  @bvt @deleteAccount
  Scenario: Delete the Opportunity on Detail Page
    When I Click on Delete from Opportunity
    Then the Opportunity should not be displayed on Home Page
