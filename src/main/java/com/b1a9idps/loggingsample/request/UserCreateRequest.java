package com.b1a9idps.loggingsample.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public final class UserCreateRequest {
    private final String name;

    @JsonCreator
    public UserCreateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserCreateRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
