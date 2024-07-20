package com.singhritik.backend.dto;

public class LoginResponse {
    private String message;
    private String role;

    // Constructor
    public LoginResponse(String message, String role) {
        this.message = message;
        this.role = role;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
