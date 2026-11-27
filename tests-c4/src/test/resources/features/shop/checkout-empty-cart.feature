Feature: Checkout with empty cart
  Nothing to buy.

  Scenario: Empty cart cannot check out
    When I check out to "221B Baker Street"
    Then checkout fails
