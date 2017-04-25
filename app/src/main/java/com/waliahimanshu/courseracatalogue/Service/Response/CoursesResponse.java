package com.waliahimanshu.courseracatalogue.Service.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoursesResponse {

    @SerializedName("elements")
    @Expose
    public List<Courses> courses = null;
    @SerializedName("paging")
    @Expose
    public Paging paging;
    @SerializedName("linked")
    @Expose
    public Linked linked;

}