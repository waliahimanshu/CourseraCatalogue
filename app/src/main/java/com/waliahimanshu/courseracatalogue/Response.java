package com.waliahimanshu.courseracatalogue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("elements")
    @Expose
    public List<Element> elements = null;
    @SerializedName("paging")
    @Expose
    public Paging paging;
    @SerializedName("linked")
    @Expose
    public Linked linked;

}