Feature: feature to test registration functionality

  Background:
    Given Browser is set up
#    And Jane is on the application home page

  Scenario: The user should be able to successfully sign up to automationpractice website
    Given User is on the homepage
    When  user enters
    Then user receives confirmation of registration