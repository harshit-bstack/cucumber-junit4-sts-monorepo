Feature: Duplicate wishlist entry
  Adding twice keeps one entry.

  Scenario: Add twice
    When I add "PX5" to my wishlist
    And I add "PX5" to my wishlist
    Then my wishlist has 1 item
