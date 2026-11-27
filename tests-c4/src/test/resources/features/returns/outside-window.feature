Feature: Return outside window
  No refund after 30 days.

  Scenario: 45 days after delivery
    Given an order of 1 x "PX5" was delivered 45 days ago
    When I request a return
    Then the return is "REJECTED"
    And the refund is 0 cents
