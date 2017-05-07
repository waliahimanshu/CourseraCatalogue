package com.waliahimanshu.courseracatalogue.api.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Linked {

    @SerializedName("partners.v1")
    public List<Partners> partners;
    @SerializedName("instructors.v1")
    public List<Instructors> instructors;

}

