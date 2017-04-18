package com.waliahimanshu.courseracatalogue.Service;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();

        retrofitService = retrofit.create(RetrofitService.class);
    }

    public Call<CoursesResponse> listAllCourses() {
        return retrofitService.listAllCourses();
    }

    @Override
    public Single<CoursesResponse> search(String query) {
        return retrofitService.search(query);
    }
}
