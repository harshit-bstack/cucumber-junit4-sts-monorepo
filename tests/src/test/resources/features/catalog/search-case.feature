Feature: Search casing
  Search ignores case.

  Scenario: Upper case query
    When I search for "GALAXY"
    Then I see 1 product
