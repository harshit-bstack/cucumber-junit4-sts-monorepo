Feature: Re-login
  A user can sign in again after logging out.

  Scenario: Log back in after logout
    Given the user "demouser" is logged in
    When "demouser" logs out
    And "demouser" logs in with password "testingisfun99"
    Then "demouser" has an active session
