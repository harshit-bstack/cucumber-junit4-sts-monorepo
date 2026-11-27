Feature: Login
  Users sign in with a username and password; accounts lock after repeated failures.

  Scenario: Valid credentials log the user in
    When "demouser" logs in with password "testingisfun99"
    Then the login result is "SUCCESS"
    And "demouser" has an active session

  Scenario: Wrong password is rejected
    When "demouser" logs in with password "nope"
    Then the login result is "INVALID_CREDENTIALS"
    And "demouser" has no active session

  Scenario: Account locks after three failed attempts
    When "demouser" fails to log in 3 times
    Then the login result is "LOCKED"
