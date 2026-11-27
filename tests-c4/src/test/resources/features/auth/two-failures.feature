Feature: Two failed attempts
  Accounts lock on the third failure, not before.

  Scenario: Two failures do not lock
    When "demouser" fails to log in 2 times
    Then the login result is "INVALID_CREDENTIALS"
