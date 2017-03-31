package com.waliahimanshu.courseracatalogue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Element {

@SerializedName("courseType")
@Expose
public String courseType;
@SerializedName("id")
@Expose
public String id;
@SerializedName("slug")
@Expose
public String slug;
@SerializedName("name")
@Expose
public String name;

}