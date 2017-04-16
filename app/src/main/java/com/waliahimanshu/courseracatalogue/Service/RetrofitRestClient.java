package com.waliahimanshu.courseracatalogue.Service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRestClient implements RetrofitService {

    private final RetrofitService retrofitService;
    private static final String BASE_URL = "https://api.coursera.org/";


    public RetrofitRestClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add logging as last interceptor
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        retrofitService = retrofit.create(RetrofitService.class);
    }

    public Call<CoursesResponse> listAllCourses() {
        return retrofitService.listAllCourses();
    }

    @Override
    public Call<CoursesResponse> search(String query) {

        return retrofitService.search(query);
    }
}
