package com.seymourapp.seymour.data.model;

import com.google.gson.annotations.SerializedName;

public class Author {

  public String id;

  @SerializedName("name")
  public String name;

  @SerializedName("url")
  public String url;

  @SerializedName("avatar")
  public String avatar;
}
