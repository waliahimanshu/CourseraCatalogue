package com.waliahimanshu.courseracatalogue.api;

import com.google.gson.annotations.SerializedName;
import com.waliahimanshu.courseracatalogue.api.instructors.InstructorsDto;
import com.waliahimanshu.courseracatalogue.api.partners.PartnersDto;

import java.util.List;

public class LinkedDto {

    @SerializedName("partners.v1")
    public List<PartnersDto> partners;
    @SerializedName("instructors.v1")
    public List<InstructorsDto> instructors;

}

