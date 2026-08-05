package com.mechanism.authentication_and_authorization.dto;

public class LoginResponse {

    private String name;
    private String role;
    private String JWT_TOKEN;

    public LoginResponse(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJWT_TOKEN() {
        return JWT_TOKEN;
    }

    public void setJWT_TOKEN(String JWT_TOKEN) {
        this.JWT_TOKEN = JWT_TOKEN;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
