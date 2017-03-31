package com.waliahimanshu.courseracatalogue;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("api/courses.v1")
    Call<Response> listRepos();
}
