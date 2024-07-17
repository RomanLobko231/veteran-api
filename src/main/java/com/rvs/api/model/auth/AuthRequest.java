package com.rvs.api.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequest {

    @JsonProperty(value = "username")
    private String principal;

    @JsonProperty(value = "password")
    private String credentials;

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public AuthRequest(String principal, String credentials) {
        this.principal = principal;
        this.credentials = credentials;
    }
}
