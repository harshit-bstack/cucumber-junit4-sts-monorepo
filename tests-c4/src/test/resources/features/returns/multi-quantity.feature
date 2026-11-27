Feature: Return several units
  Refund scales with quantity.

  Scenario: Two phones
    Given an order of 2 x "IP12" was delivered 5 days ago
    When I request a return
    Then the refund is 159800 cents
