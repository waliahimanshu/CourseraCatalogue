package com.waliahimanshu.courseracatalogue.api.instructors;


import com.google.gson.annotations.SerializedName;

public class InstructorsDto {

    @SerializedName("fullName")
    public String name;

    @SerializedName("id")
    public String id;

    @SerializedName("photo")
    public String photo;

    @SerializedName("bio")
    public String bio;
}
