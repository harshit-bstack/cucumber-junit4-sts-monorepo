package com.demo.shop.tests.steps;

import com.demo.shop.auth.AuthService;
import com.demo.shop.auth.AuthService.LoginResult;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AuthSteps {
    private final AuthService auth = new AuthService();
    private LoginResult lastResult;

    @Given("the user {string} is logged in")
    public void loggedIn(String user) {
        assertEquals(LoginResult.SUCCESS, auth.login(user, "testingisfun99"));
    }

    @When("{string} logs in with password {string}")
    public void login(String user, String password) {
        lastResult = auth.login(user, password);
    }

    @When("{string} fails to log in {int} times")
    public void failLogins(String user, int times) {
        for (int i = 0; i < times; i++) lastResult = auth.login(user, "wrong-password");
    }

    @When("{string} logs out")
    public void logout(String user) {
        auth.logout(user);
    }

    @Then("the login result is {string}")
    public void loginResult(String expected) {
        assertEquals(LoginResult.valueOf(expected), lastResult);
    }

    @Then("{string} has an active session")
    public void hasSession(String user) {
        assertTrue(auth.isLoggedIn(user));
    }

    @Then("{string} has no active session")
    public void noSession(String user) {
        assertFalse(auth.isLoggedIn(user));
    }
}
