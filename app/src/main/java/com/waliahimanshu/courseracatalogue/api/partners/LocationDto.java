package com.waliahimanshu.courseracatalogue.api.partners;

import com.google.gson.annotations.SerializedName;

public class LocationDto {

    @SerializedName("country")
    String country  ;

    @SerializedName("city")
    String city;

    @SerializedName("name")
    String name;

    @SerializedName("state")
    String state;

    @SerializedName("latitude")
    double latitude;

    @SerializedName("longitude")
    double longitude;
}
