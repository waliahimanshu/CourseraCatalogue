package com.waliahimanshu.courseracatalogue.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PagingDto {

    @SerializedName("next")
    @Expose
    public String next;

    @SerializedName("total")
    @Expose
    public Integer total;

}