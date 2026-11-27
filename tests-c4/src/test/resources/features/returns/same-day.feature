Feature: Same-day return
  Delivered today.

  Scenario: Zero days
    Given an order of 1 x "GS20" was delivered 0 days ago
    When I request a return
    Then the return is "APPROVED"
