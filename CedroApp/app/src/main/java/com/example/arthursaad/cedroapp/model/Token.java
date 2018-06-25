package com.example.arthursaad.cedroapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("type")
    private String type;
    @SerializedName("token")
    private String token;

    public Token() {
    }

    public Token(String type, String token) {
        super();
        this.type = type;
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}