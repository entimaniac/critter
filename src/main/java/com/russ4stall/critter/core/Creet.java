package com.russ4stall.critter.core;

import java.sql.Timestamp;

/**
 * Created by russellf on 10/24/2014.
 */
public class Creet {
    private int id;
    private String message;
    private String groupId;
    private String userId;
    private Timestamp timestamp;
    private boolean sentToTwitter;
    private Score score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean hasBeenSentToTwitter() {
        return sentToTwitter;
    }

    public void setSentToTwitter(boolean sentToTwitter) {
        this.sentToTwitter = sentToTwitter;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
