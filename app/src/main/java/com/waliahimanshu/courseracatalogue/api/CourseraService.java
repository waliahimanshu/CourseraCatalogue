package com.waliahimanshu.courseracatalogue.api;

import com.waliahimanshu.courseracatalogue.api.instructors.InstructorResponseDto;
import com.waliahimanshu.courseracatalogue.api.courses.CoursesResponse;
import com.waliahimanshu.courseracatalogue.api.partners.PartnerResponseDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CourseraService {

    @GET("api/cours.v1?includes=partnerIds,instructorIds&fields=partnerIds,instructorIds,partnerLogo,photoUrl,description,primaryLanguages,subtitleLanguages,certificates,startDate,workload,previewLink,specializations,s12nlds,domainTypes,categories&limit=7")
    Single<CoursesResponse> getAllCourses();

    /**
     * Additional query parameters which can be applied
     * Query("start") String start
     * Query("limit") String limit
     */
    @GET("api/cours.v1?includes=partnerIds,instructorIds&fields=partnerIds,instructorIds&q=search")
    Single<CoursesResponse> search(@Query("query") String query);


    @GET("api/partners.v1?includes=instructorIds&fields=instructorIds,name,description,banner,courseIds," +
            "primaryColor,logo,squareLogo,rectangularLogo,links,location&limit=7")
    Single<PartnerResponseDto> getPartners();


    @GET("api/instructors.v1?fields=bio,photo&limit=7")
    Single<InstructorResponseDto> getInstructors();


}


