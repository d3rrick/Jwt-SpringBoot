package io.guru.securityjwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class AuthResponse implements Serializable {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private int expiresIn;

    public AuthResponse(String accessToken, int expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }


}
