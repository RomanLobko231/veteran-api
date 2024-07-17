package com.rvs.api.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {

    @JsonProperty(value = "token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthResponse(String token) {
        this.token = token;
    }
}
