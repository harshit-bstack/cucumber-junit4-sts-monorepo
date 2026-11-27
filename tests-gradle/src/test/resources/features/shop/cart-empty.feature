Feature: Empty cart
  A new cart is empty.

  Scenario: Fresh cart
    Then my cart has 0 items
    And my cart subtotal is 0 cents
