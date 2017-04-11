package com.waliahimanshu.courseracatalogue.Service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRestClient implements RetrofitService {

    private final RetrofitService retrofitService1;
    private static final String BASE_URL = "https://api.coursera.org/";

    //https://api.coursera.org/api/courses.v1?includes=partnerIds,instructorIds&fields=partnerIds,instructorIds&limit=110

    public RetrofitRestClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitService1 = retrofit.create(RetrofitService.class);
    }

    public Call<CoursesResponse> listAllCourses() {
       return retrofitService1.listAllCourses();
    }
}
