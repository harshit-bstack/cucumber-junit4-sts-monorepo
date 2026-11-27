Feature: Add a review
  Rate a product.

  Scenario: One review
    When I review "PX5" with 5 stars
    Then "PX5" has 1 review
