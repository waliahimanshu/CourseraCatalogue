package com.waliahimanshu.courseracatalogue.api;

import com.flextrade.jfixture.JFixture;
import com.waliahimanshu.courseracatalogue.api.instructors.InstructorResponseDto;
import com.waliahimanshu.courseracatalogue.api.courses.CoursesResponse;
import com.waliahimanshu.courseracatalogue.api.partners.PartnerResponseDto;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;

public class MockCourseraService implements CourseraService {


    private final BehaviorDelegate<CourseraService> delegate;
    private MockRetrofit mockRetrofit;
    private final JFixture jFixture;

    @Inject
    public MockCourseraService(MockRetrofit mockRetrofit) {
        this.mockRetrofit = mockRetrofit;
        this.delegate = mockRetrofit.create(CourseraService.class);
        jFixture = new JFixture();


    }

    @Override
    public Single<CoursesResponse> getAllCourses() {
        CoursesResponse response = jFixture.create(CoursesResponse.class);
        return Single.just(response);
    }

    @Override
    public Single<CoursesResponse> search(String query) {
        return null;
    }

    @Override
    public Single<PartnerResponseDto> getPartners() {
        PartnerResponseDto response = jFixture.create(PartnerResponseDto.class);
        return Single.just(response);
    }

    @Override
    public Single<InstructorResponseDto> getInstructors() {
        InstructorResponseDto response = jFixture.create(InstructorResponseDto.class);
        return Single.just(response);
    }
}


