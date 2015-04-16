package com.russ4stall.critter.core;

import java.sql.Timestamp;

/**
 * @author Russ Forstall
 */
public class Creet {
    private String id;
    private String message;
    private String groupId;
    private User author;
    private Timestamp timestamp;
    private boolean sentToTwitter;
    private int score;

    public Creet(String id, String message, String groupId, User author, Timestamp timestamp, boolean sentToTwitter, int score) {
        this.id = id;
        this.message = message;
        this.groupId = groupId;
        this.author = author;
        this.timestamp = timestamp;
        this.sentToTwitter = sentToTwitter;
        this.score = score;
    }

    public Creet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public boolean hasBeenSentToTwitter() {
        return sentToTwitter;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
