Feature: Bulk discount
  Three or more units of the same product get 10% off that line.

  Scenario: Three units are discounted
    When I add 3 x "PX5" to my cart
    Then my cart subtotal is 188730 cents

  Scenario: Two units are not discounted
    When I add 2 x "PX5" to my cart
    Then my cart subtotal is 139800 cents

  Scenario: Five units are discounted
    When I add 5 x "GS20" to my cart
    Then my cart subtotal is 337050 cents
