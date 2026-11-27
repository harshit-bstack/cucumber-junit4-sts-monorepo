Feature: Lockout persists
  A locked account stays locked even with the right password.

  Scenario: Right password does not unlock
    When "locked_user" fails to log in 3 times
    And "locked_user" logs in with password "testingisfun99"
    Then the login result is "LOCKED"
