package com.waliahimanshu.courseracatalogue.api.courses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoursesDto {

    @SerializedName("courseType")
    public String courseType;

    @SerializedName("id")
    public String id;

    @SerializedName("slug")
    public String slug;

    @SerializedName("description")
    public String description;

    @SerializedName("name")
    public String name;

    @SerializedName("photoUrl")
    public String photoUrl;

    @SerializedName("instructorIds")
    public List<String> instructorIds;

    @SerializedName("partnerIds")
    public List<String> partnerIds;
}