Feature: Checkout with a bulk discount
  The discounted subtotal drives shipping and tax.

  Scenario: Discounted order ships free
    Given my cart contains 3 x "PX5"
    When I check out to "221B Baker Street"
    Then shipping is free
    And the order total is 203828 cents
