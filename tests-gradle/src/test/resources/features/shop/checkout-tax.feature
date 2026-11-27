Feature: Checkout tax
  Tax is 8% of the subtotal.

  Scenario: Laptop pays shipping and tax
    Given my cart contains 1 x "MBA"
    When I check out to "221B Baker Street"
    Then the order total is 108891 cents
