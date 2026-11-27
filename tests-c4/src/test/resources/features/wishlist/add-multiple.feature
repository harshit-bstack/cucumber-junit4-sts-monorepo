Feature: Several wishlist entries
  Keep many.

  Scenario: Three items
    When I add "IP12" to my wishlist
    And I add "MBA" to my wishlist
    And I add "GS20" to my wishlist
    Then my wishlist has 3 items
