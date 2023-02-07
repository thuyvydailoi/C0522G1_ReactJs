package com.codegym.payload;

public class LoginResponse {
    private String username;
    private String password;

    public LoginResponse(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
