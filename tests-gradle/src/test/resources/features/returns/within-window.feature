Feature: Return within window
  Refund in full inside 30 days.

  Scenario: 10 days after delivery
    Given an order of 1 x "PX5" was delivered 10 days ago
    When I request a return
    Then the return is "APPROVED"
    And the refund is 69900 cents
