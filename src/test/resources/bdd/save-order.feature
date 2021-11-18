Feature: Saving Orders

  Scenario: Saving new order with success
    Given I have a valid order
    When I call service to save the new order
    Then  I receive the code 201
