package com.ankush.sampleproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("name")
    public String name;
    @JsonProperty("Email")
    public String email;
    @JsonProperty("Password")
    public String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
