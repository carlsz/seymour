package com.seymourapp.seymour.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedCollection {

    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("feeds")
    public List<Feed> feeds;
}
