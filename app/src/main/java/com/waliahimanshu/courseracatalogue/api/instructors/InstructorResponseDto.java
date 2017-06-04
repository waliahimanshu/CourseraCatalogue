package com.waliahimanshu.courseracatalogue.api.instructors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.waliahimanshu.courseracatalogue.api.LinkedDto;
import com.waliahimanshu.courseracatalogue.api.PagingDto;

import java.util.List;

/**
 * Created by waliahimanshu.
 */

public class InstructorResponseDto {

    @SerializedName("elements")
    @Expose
    public List<InstructorsDto> instructorsDtos = null;

    @SerializedName("paging")
    @Expose
    public PagingDto pagingDto;

    @SerializedName("linked")
    @Expose
    public LinkedDto linkedDto;
}
