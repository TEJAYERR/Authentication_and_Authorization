package com.mechanism.authentication_and_authorization.dto;

public class UserProfileResponse {

    String name;
    String email;

    public UserProfileResponse(){}

    public UserProfileResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
