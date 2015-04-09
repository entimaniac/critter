package com.russ4stall.critter.core;

/**
 * Created by russellf on 10/24/2014.
 */
public class Group {
    private String id;
    private String name;
    private String twitterHandle;
    private String description;
    private int threshold;
    private String owner;
    private String twitterAccessToken;

    public Group(String id, String name, String twitterHandle, String description, int threshold, String owner, String twitterAccessToken) {
        this.id = id;
        this.name = name;
        this.twitterHandle = twitterHandle;
        this.description = description;
        this.threshold = threshold;
        this.owner = owner;
        this.twitterAccessToken = twitterAccessToken;
    }

    public Group() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTwitterAccessToken() {
        return twitterAccessToken;
    }
}
