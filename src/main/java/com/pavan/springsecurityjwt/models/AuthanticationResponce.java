package com.pavan.springsecurityjwt.models;

public class AuthanticationResponce {
    private String jwt;

    public AuthanticationResponce(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
