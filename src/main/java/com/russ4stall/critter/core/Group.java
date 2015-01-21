package com.russ4stall.critter.core;

/**
 * Created by russellf on 10/24/2014.
 */
public class Group {
    private int id;
    private String name;
    private String twitterHandle;
    private int owner;

    public Group(int id, String name, String twitterHandle, int owner) {
        this.id = id;
        this.name = name;
        this.twitterHandle = twitterHandle;
        this.owner = owner;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
