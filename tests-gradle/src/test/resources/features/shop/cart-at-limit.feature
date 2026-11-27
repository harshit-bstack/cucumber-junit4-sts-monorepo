Feature: Cart at the limit
  Five of a kind is allowed.

  Scenario: Five units allowed
    When I add 5 x "IP12" to my cart
    Then my cart has 5 items
