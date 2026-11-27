Feature: Checkout
  Order total = subtotal + shipping (free over $1000) + 8% tax.

  Scenario: Small order pays shipping
    Given my cart contains 1 x "PX5"
    When I check out to "221B Baker Street"
    Then the order total is 76491 cents

  Scenario: Large order ships free
    Given my cart contains 1 x "XPS"
    When I check out to "221B Baker Street"
    Then shipping is free
    And the order total is 118692 cents

  Scenario: Checkout needs a shipping address
    Given my cart contains 1 x "MBA"
    When I check out to ""
    Then checkout fails
