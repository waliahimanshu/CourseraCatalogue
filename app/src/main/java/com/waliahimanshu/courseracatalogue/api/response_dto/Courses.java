package com.waliahimanshu.courseracatalogue.api.response_dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Courses {

    @SerializedName("courseType")
    public String courseType;

    @SerializedName("id")
    public String id;

    @SerializedName("slug")
    public String slug;

    @SerializedName("name")
    public String name;

    @SerializedName("photoUrl")
    public String photoUrl;

    @SerializedName("instructorIds")
    public List<String > instructorIds;

    @SerializedName("partnerIds")
    public List<String> partnerIds;
}