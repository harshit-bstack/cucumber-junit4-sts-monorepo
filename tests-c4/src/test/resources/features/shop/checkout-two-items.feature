Feature: Checkout two products
  Mixed cart ships free over $1000.

  Scenario: Phone and laptop
    Given my cart contains 1 x "MBA"
    And my cart contains 1 x "IP12"
    When I check out to "221B Baker Street"
    Then shipping is free
    And the order total is 194184 cents
