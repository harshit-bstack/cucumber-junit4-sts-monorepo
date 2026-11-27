Feature: Logout
  Logging out ends the user's session.

  Scenario: Logged-in user logs out
    Given the user "demouser" is logged in
    When "demouser" logs out
    Then "demouser" has no active session
