Feature: Shopping cart
  Shoppers add and remove products; quantities are capped per item.

  Scenario: Adding products updates count and subtotal
    When I add 2 x "PX5" to my cart
    Then my cart has 2 items
    And my cart subtotal is 139800 cents

  Scenario: Removing a product
    Given my cart contains 1 x "IP12"
    When I remove "IP12" from my cart
    Then my cart has 0 items

  Scenario: Quantity per item is capped at five
    Given my cart contains 5 x "GS20"
    When I add 1 x "GS20" to my cart
    Then adding more is rejected
