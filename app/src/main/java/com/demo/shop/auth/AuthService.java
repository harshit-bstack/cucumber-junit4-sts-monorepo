package com.demo.shop.auth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Username/password login with account lockout after repeated failures. */
public class AuthService {
    public static final int MAX_FAILED_ATTEMPTS = 3;

    private final Map<String, String> passwords = new HashMap<>();
    private final Map<String, Integer> failures = new HashMap<>();
    private final Set<String> sessions = new HashSet<>();

    public AuthService() {
        passwords.put("demouser", "testingisfun99");
        passwords.put("locked_user", "testingisfun99");
    }

    public LoginResult login(String username, String password) {
        if (failures.getOrDefault(username, 0) >= MAX_FAILED_ATTEMPTS) {
            return LoginResult.LOCKED;
        }
        String expected = passwords.get(username);
        if (expected == null || !expected.equals(password)) {
            failures.merge(username, 1, Integer::sum);
            return failures.get(username) >= MAX_FAILED_ATTEMPTS ? LoginResult.LOCKED : LoginResult.INVALID_CREDENTIALS;
        }
        failures.remove(username);
        sessions.add(username);
        return LoginResult.SUCCESS;
    }

    public void logout(String username) {
        sessions.remove(username);
    }

    public boolean isLoggedIn(String username) {
        return sessions.contains(username);
    }

    public enum LoginResult { SUCCESS, INVALID_CREDENTIALS, LOCKED }
}
