Feature: Add to wishlist
  Save products for later.

  Scenario: Add one
    Given my wishlist is empty
    When I add "PX5" to my wishlist
    Then my wishlist has 1 item
    And my wishlist contains "PX5"
