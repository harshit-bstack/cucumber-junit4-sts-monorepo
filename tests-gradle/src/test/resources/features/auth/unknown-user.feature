Feature: Unknown user
  Unknown accounts are rejected.

  Scenario: Unknown account cannot log in
    When "ghost" logs in with password "whatever"
    Then the login result is "INVALID_CREDENTIALS"
    And "ghost" has no active session
