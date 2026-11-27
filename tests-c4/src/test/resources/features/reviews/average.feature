Feature: Average rating
  Mean of stars.

  Scenario: Two ratings
    When I review "IP12" with 4 stars
    And I review "IP12" with 5 stars
    Then the average rating of "IP12" is 4.5
