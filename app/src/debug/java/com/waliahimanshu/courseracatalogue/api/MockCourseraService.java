package com.waliahimanshu.courseracatalogue.api;

import com.flextrade.jfixture.JFixture;
import com.waliahimanshu.courseracatalogue.api.response_dto.CoursesResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;

public class MockCourseraService implements CourseraService {


    private final BehaviorDelegate<CourseraService> delegate;
    private MockRetrofit mockRetrofit;

    @Inject
    public MockCourseraService(MockRetrofit mockRetrofit) {
        this.mockRetrofit = mockRetrofit;
        this.delegate = mockRetrofit.create(CourseraService.class);

    }

    @Override
    public Single<CoursesResponse> getAllCourses() {
        CoursesResponse response = new JFixture().create(CoursesResponse.class);
        return Single.just(response);
    }

    @Override
    public Single<CoursesResponse> search(String query) {
        return null;
    }
}


