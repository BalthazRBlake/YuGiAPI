package org.dev.fhhf.YuGi.security;

import java.io.Serializable;

public class AuthenticationResponseModel implements Serializable {

    private final String jwt;

    public AuthenticationResponseModel(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
