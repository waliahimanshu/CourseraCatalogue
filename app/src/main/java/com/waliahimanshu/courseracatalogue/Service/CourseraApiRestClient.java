package com.waliahimanshu.courseracatalogue.Service;

import com.waliahimanshu.courseracatalogue.Service.Response.CoursesResponse;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CourseraApiRestClient implements CourseraApiService {

    private final CourseraApiService courseraApiService;
    private static final String BASE_URL = "https://api.coursera.org/";


    public CourseraApiRestClient() {

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

        courseraApiService = retrofit.create(CourseraApiService.class);
    }

    public Call<CoursesResponse> listAllCourses() {
        return courseraApiService.listAllCourses();
    }

    @Override
    public Single<CoursesResponse> search(String query) {
        return courseraApiService.search(query);
    }
}
