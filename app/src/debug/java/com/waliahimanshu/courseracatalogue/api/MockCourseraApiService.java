package com.waliahimanshu.courseracatalogue.api;

import com.waliahimanshu.courseracatalogue.api.response_dto.CoursesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MockCourseraApiService implements CourseraApiService {

    @Override
    public Single<CoursesResponse> getAllCourses() {
        return null;
    }

    @Override
    public Single<CoursesResponse> search(String query) {
        return null;
    }
}


