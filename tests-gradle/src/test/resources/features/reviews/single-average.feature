Feature: Single review average
  One rating is its own mean.

  Scenario: One rating
    When I review "GS20" with 2 stars
    Then the average rating of "GS20" is 2.0
