package com.waliahimanshu.courseracatalogue.api.courses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.waliahimanshu.courseracatalogue.api.LinkedDto;
import com.waliahimanshu.courseracatalogue.api.PagingDto;

import java.util.List;

public class CoursesResponse {

    @SerializedName("elements")
    @Expose
    public List<CoursesDto> course = null;

    @SerializedName("paging")
    @Expose
    public PagingDto pagingDto;

    @SerializedName("linked")
    @Expose
    public LinkedDto linkedDto;

}