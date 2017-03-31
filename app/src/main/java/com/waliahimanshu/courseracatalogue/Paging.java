package com.waliahimanshu.courseracatalogue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paging {

    @SerializedName("next")
    @Expose
    public String next;
    @SerializedName("total")
    @Expose
    public Integer total;

}