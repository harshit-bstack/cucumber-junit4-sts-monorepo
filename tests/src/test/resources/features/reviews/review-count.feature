Feature: Review count
  Counts per product.

  Scenario: Three reviews
    When I review "XPS" with 3 stars
    And I review "XPS" with 4 stars
    And I review "XPS" with 5 stars
    Then "XPS" has 3 reviews
