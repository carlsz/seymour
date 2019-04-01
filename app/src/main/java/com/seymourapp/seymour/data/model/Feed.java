package com.seymourapp.seymour.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed {

  public String id;

  @SerializedName("version")
  public String version;

  @SerializedName("title")
  public String title;

  @SerializedName("home_page_url")
  public String homePageUrl;

  @SerializedName("feed_url")
  public String feedUrl;

  @SerializedName("description")
  public String description;

  @SerializedName("next_url")
  public String nextUrl;

  @SerializedName("icon")
  public String icon;

  @SerializedName("favicon")
  public String favicon;

  @SerializedName("author")
  public Author author;

  @SerializedName("expired")
  public boolean expired;

  @SerializedName("items")
  public List<FeedItem> items;
}
