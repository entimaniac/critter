package com.russ4stall.critter.core;

/**
 * @author Russ Forstall
 */
public class Group {
    private String id;
    private String name;
    private String twitterHandle;
    private String description;
    private int threshold;
    private String owner;

    public Group(String id, String name, String twitterHandle, String description, int threshold, String owner) {
        this.id = id;
        this.name = name;
        this.twitterHandle = twitterHandle;
        this.description = description;
        this.threshold = threshold;
        this.owner = owner;
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

    public String getDescription() {
        return description;
    }

    public int getThreshold() {
        return threshold;
    }

    public String getOwner() {
        return owner;
    }

}

