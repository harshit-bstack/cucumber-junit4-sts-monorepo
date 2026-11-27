Feature: Refund of bulk-discounted purchases
  A discounted line is refunded at the discounted price.

  Scenario: Three units refunded at the discounted price
    Given an order of 3 x "PX5" was delivered 7 days ago
    When I request a return
    Then the return is "APPROVED"
    And the refund is 188730 cents
