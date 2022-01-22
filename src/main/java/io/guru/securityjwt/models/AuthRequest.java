package io.guru.securityjwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class AuthRequest implements Serializable {

    @JsonProperty("username")
    private String userName = null;
    @JsonProperty("password")
    private String passWord = null;

    public AuthRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

}
