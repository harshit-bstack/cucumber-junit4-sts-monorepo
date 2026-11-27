Feature: Cart with several products
  Several products add up.

  Scenario: Two different products
    When I add 2 x "PX5" to my cart
    And I add 1 x "IP12" to my cart
    Then my cart has 3 items
    And my cart subtotal is 219700 cents
