package com.waliahimanshu.courseracatalogue.api;

import com.waliahimanshu.courseracatalogue.api.response_dto.CoursesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CourseraService {

    @GET("api/courses.v1?includes=partnerIds,instructorIds&fields=partnerIds,instructorIds,partnerLogo,photoUrl,description,primaryLanguages,subtitleLanguages,certificates,startDate,workload,previewLink,specializations,s12nlds,domainTypes,categories")
    Single<CoursesResponse> getAllCourses();

    /**
     * Additional query parameters which can be applied
     * Query("start") String start
     * Query("limit") String limit
     */
    @GET("api/courses.v1?includes=partnerIds,instructorIds&fields=partnerIds,instructorIds&q=search")
    Single<CoursesResponse> search(@Query("query") String query);
}


