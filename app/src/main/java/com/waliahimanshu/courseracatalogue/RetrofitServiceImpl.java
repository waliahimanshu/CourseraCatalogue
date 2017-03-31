package com.waliahimanshu.courseracatalogue;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitServiceImpl implements RetrofitService {

    private final RetrofitService retrofitService1;

    public RetrofitServiceImpl () {

        String baseUrl="https://api.coursera.org/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitService1 = retrofit.create(RetrofitService.class);
    }

    public Call<Response> listRepos() {
       return retrofitService1.listRepos();
    }
}
