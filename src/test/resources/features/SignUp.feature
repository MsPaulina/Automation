@common
Feature: feature to test registration functionality

  Background:
    Given Browser is set up

  Scenario Outline: The user should be able to successfully sign up to automationpractice website
    Given User is on the homepage
    When user goes to sign up page
    When user selects their title "<title>"
    When user enters first name
    When user enters last name
    When user creates password
    When user selects date of birth   <dBirth>, <mBirth>, <yBirth>
    When user enters setReceiveOffers "<offerYorN>"
    When user enters their address
    When user enters their city of residence "<city>"
    When user selects their state of residence "<state>"
    When user enters their postal code  "<postalC>"
    When user selects their country of residence  "<country>"
    When user enters additional information
    When user enters mobile phone number
    When user enters alias email address
    When user click register button
    Then user receives confirmation of registration

    Examples:
      | title |  | offerYorN |  | dBirth |  | mBirth |  | yBirth |  | city  |  | state    |  | postalC |  | country       |
      | mr    |  | Yes       |  | 12     |  | 4      |  | 1999   |  | Ęśąćż |  | New York |  | 12345   |  | United States |


