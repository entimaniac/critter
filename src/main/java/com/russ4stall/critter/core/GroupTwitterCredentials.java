package com.russ4stall.critter.core;

/**
 * Created by russellf on 4/9/2015.
 */
public class GroupTwitterCredentials {
    private String groupId;
    private String token;
    private String tokenSecret;

    public GroupTwitterCredentials(String groupId, String token, String tokenSecret) {
        this.groupId = groupId;
        this.token = token;
        this.tokenSecret = tokenSecret;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getToken() {
        return token;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }
}
