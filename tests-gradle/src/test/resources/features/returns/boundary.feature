Feature: Return on last day
  Day 30 still counts.

  Scenario: 30 days after delivery
    Given an order of 1 x "MBA" was delivered 30 days ago
    When I request a return
    Then the return is "APPROVED"
