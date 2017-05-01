package com.waliahimanshu.courseracatalogue.api;

import com.waliahimanshu.courseracatalogue.api.Response.CoursesResponse;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CourseraApiService {

    @GET("api/courses.v1")
    Single<CoursesResponse> getAllCourses();

    /**
     * Additional query parameters which can be applied
     * Query("start") String start
     * Query("limit") String limit
     */
    @GET("api/courses.v1?includes=partnerIds,instructorIds&fields=partnerIds,instructorIds&q=search")
    Single<CoursesResponse> search(@Query("query") String query);
}


