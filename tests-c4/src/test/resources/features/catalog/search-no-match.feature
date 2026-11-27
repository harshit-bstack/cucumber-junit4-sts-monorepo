Feature: Search without match
  Nothing found.

  Scenario: No match
    When I search for "zzz"
    Then I see 0 products
