Feature: Remove absent item
  Removing something not saved is harmless.

  Scenario: Remove absent
    Given I add "IP12" to my wishlist
    When I remove "MBA" from my wishlist
    Then my wishlist has 1 item
