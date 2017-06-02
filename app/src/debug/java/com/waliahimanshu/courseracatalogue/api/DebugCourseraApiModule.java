package com.waliahimanshu.courseracatalogue.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.waliahimanshu.courseracatalogue.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by waliahimanshu.
 */
@Module
public class DebugCourseraApiModule {
    private static final String BASE_URL = "https://api.coursera.org/";

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient_debug() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
            builder.addInterceptor(new StethoInterceptor());

        }

        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        return builder.build();
    }


    @Provides
    @Singleton
    NetworkBehavior provideBehavior_debug() {
        NetworkBehavior behavior = NetworkBehavior.create();
        behavior.setDelay(5, MILLISECONDS);
        behavior.setFailurePercent(0);
        behavior.setVariancePercent(0);
        return behavior;
    }

    @Provides
    @Singleton
    MockRetrofit provideMockRetrofit(Retrofit retrofit,
                                     NetworkBehavior behavior) {
        return new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior)
                .build();
    }

    @Provides
    @Singleton
    CourseraService provideMockCourseraService(MockCourseraService mockService) {
        return  mockService ;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofitRestAdapter_debug(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
