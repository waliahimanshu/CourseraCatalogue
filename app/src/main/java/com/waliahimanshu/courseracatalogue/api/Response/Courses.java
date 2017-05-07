package com.waliahimanshu.courseracatalogue.api.Response;

import com.google.gson.annotations.SerializedName;


public class Courses {

    @SerializedName("courseType")
    public String courseType;

    @SerializedName("id")
    public String id;

    @SerializedName("slug")
    public String slug;

    @SerializedName("name")
    public String name;

    @SerializedName("instructorIds")
    public String[] instructorIds;

    @SerializedName("partnerIds")
    public String [] partnerIds;

}