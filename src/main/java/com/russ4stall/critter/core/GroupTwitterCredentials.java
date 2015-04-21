package com.russ4stall.critter.core;


/**
 * @author Russ Forstall
 */
public class GroupTwitterCredentials {
    private String groupId;
    private String screenName;
    private long userId;
    private String token;
    private String tokenSecret;

    public GroupTwitterCredentials(String groupId, String screenName, long userId, String token, String tokenSecret) {
        this.groupId = groupId;
        this.screenName = screenName;
        this.userId = userId;
        this.token = token;
        this.tokenSecret = tokenSecret;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getScreenName() {
        return screenName;
    }

    public long getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }
}
