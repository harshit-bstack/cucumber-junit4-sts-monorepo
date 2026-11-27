Feature: Invalid stars
  Only 1-5 are valid.

  Scenario: Six stars
    When I review "MBA" with 6 stars
    Then the review is rejected
