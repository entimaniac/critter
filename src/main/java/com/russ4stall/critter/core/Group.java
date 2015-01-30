package com.russ4stall.critter.core;

/**
 * Created by russellf on 10/24/2014.
 */
public class Group {
    private String id;
    private String name;
    private String twitterHandle;
    private String owner;

    public Group(String id, String name, String twitterHandle, String owner) {
        this.id = id;
        this.name = name;
        this.twitterHandle = twitterHandle;
        this.owner = owner;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
