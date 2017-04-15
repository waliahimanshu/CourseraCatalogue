package com.waliahimanshu.courseracatalogue;

import com.waliahimanshu.courseracatalogue.Service.CoursesResponse;

import retrofit2.Response;

public interface HomeActivityContract {

    interface Presenter {

        Response<CoursesResponse> loadData(String query, String start, String limit);

    }

    interface View {

    }
}
