package com.seymourapp.seymour.data.model;

import com.google.gson.annotations.SerializedName;

public class Attachment {

    public String id;

    @SerializedName("url")
    public String url;

    @SerializedName("mime_type")
    public String mimeType;

    @SerializedName("title")
    public String title;

    @SerializedName("size_in_bytes")
    public int sizeInBytes;

    @SerializedName("duration_in_seconds")
    public int durationInSeconds;

}
