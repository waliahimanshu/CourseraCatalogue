package com.waliahimanshu.courseracatalogue.Service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("api/courses.v1")
    Call<CoursesResponse> listAllCourses();
}
