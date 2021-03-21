package com.b1a9idps.loggingsample.response;

public final class UserResponse {
    int id;
    String name;

    private UserResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserResponse newInstance(int id, String name) {
        return new UserResponse(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
