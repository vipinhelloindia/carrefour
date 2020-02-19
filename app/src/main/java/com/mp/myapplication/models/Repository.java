package com.mp.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Repository {

    @SerializedName("id")
    private int id;

    @SerializedName("node_id")
    String nodeId;

    @SerializedName("name")
    private String name;

    @SerializedName("private")
    private boolean isPrivate;

    @SerializedName("html_url")
    private String link;

    @SerializedName("description")
    private String description;

    @SerializedName("full_name")
    String full_name;

    @SerializedName("owner")
    private User owner;

    @SerializedName("size")
    private long size;

    @SerializedName("fork")
    private boolean fork;

    @SerializedName("updated_at")
    String updateDate;

    @SerializedName("language")
    String language;

    @SerializedName("watchers")
    long watcher;

    @SerializedName("forks_count")
    long forksCount;


    public long getForksCount() {
        return forksCount;
    }

    public long getWatcher() {
        return watcher;
    }

    public String getLanguage() {
        return language;
    }

    public int getId() {
        return id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getName() {
        return name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getFullName() {
        return full_name;
    }

    public User getOwner() {
        return owner;
    }

    public long getSize() {
        return size;
    }

    public boolean isFork() {
        return fork;
    }

    public String getUpdateDate() {
        return updateDate;
    }

}