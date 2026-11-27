Feature: Partial search
  Partial names match.

  Scenario: Partial name
    When I search for "mac"
    Then I see 1 product
