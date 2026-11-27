Feature: Remove from wishlist
  Drop saved products.

  Scenario: Remove one
    Given I add "XPS" to my wishlist
    When I remove "XPS" from my wishlist
    Then my wishlist does not contain "XPS"
