Feature: Browse unknown category
  Unknown categories are empty.

  Scenario: Unknown category
    When I browse the "toys" category
    Then I see 0 products
