package com.seymourapp.seymour.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class FeedItem {

  public String id;

  @SerializedName("url")
  public String url;

  @SerializedName("external_url")
  public String externalUrl;

  @SerializedName("title")
  public String title;

  @SerializedName("content_html")
  public String contentHtml;

  @SerializedName("content_text")
  public String contentText;

  @SerializedName("summary")
  public String summary;

  @SerializedName("image")
  public String image;

  @SerializedName("banner_image")
  public String bannerImage;

  @SerializedName("date_published")
  public Date datePublished;

  @SerializedName("date_modified")
  public Date dateModified;

  @SerializedName("author")
  public Author author;

  @SerializedName("tags")
  public List<String> tags;

  @SerializedName("attachments")
  public List<Attachment> attachments;

}
