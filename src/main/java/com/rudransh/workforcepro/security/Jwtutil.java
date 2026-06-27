package com.rudransh.workforcepro.security;

public class Jwtutil {

    private static final String SECRET_KEY = "rudransh_secret_key";

    public String getSecretKey() {
        return SECRET_KEY;
    }
}