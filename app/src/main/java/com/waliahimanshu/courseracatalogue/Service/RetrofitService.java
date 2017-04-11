package com.waliahimanshu.courseracatalogue.Service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("api/courses.v1")
    Call<CoursesResponse> listAllCourses();

    @GET("api/courses.v1q=search&query={searchText}")
    Call<CoursesResponse> search(@Path("searchText") String searchText);
}


