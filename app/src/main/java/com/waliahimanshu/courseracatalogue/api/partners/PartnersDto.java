package com.waliahimanshu.courseracatalogue.api.partners;


import com.google.gson.annotations.SerializedName;
import com.waliahimanshu.courseracatalogue.api.partners.LocationDto;
import com.waliahimanshu.courseracatalogue.api.partners.SocialMediaLinksDto;

import java.util.List;

public class PartnersDto {
    @SerializedName("name")
    public String name;

    @SerializedName("id")
    public String id;

    @SerializedName("shortName")
    public String shortName;

    @SerializedName("courseIds")
    public List<String> courseIds;

    @SerializedName("instructorIds")
    public List<String> instructorIds;

    @SerializedName("primaryColor")
    String primaryColor;

    @SerializedName("description")
    String description;

    @SerializedName("rectangularLogo")
    String rectangularLogo;

    @SerializedName("logo")
    public  String logo;

    @SerializedName("squareLogo")
    String squareLogo;

    @SerializedName("links")
    SocialMediaLinksDto socialMediaLinksDto;

    @SerializedName("location")
    LocationDto locations;

}
