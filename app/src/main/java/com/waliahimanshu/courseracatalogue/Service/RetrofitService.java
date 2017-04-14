package com.waliahimanshu.courseracatalogue.Service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("api/courses.v1")
    Call<CoursesResponse> listAllCourses();

    @GET("api/courses.v1?q=search")
    Call<CoursesResponse> search(@Query("start") String newText, @Query("limit") String start, @Query("query") String searchText);
}


