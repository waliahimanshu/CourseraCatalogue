package com.waliahimanshu.courseracatalogue.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.waliahimanshu.courseracatalogue.BuildConfig;
import com.waliahimanshu.courseracatalogue.api.CourseraService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class CourseraApiModule {
    private static final String CACHE_CONTROL = "Cache-Control";

    private static final String BASE_URL = "https://api.coursera.org/";
    private Context context;

    public CourseraApiModule(Context context) {

        this.context = context;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024));
        builder.interceptors(provideCacheInterceptor());

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(getHttpLoggingInterceptor());
            builder.addInterceptor(getStethoInterceptor());
        }

        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        return builder.build();
    }

    private StethoInterceptor getStethoInterceptor() {
        return new StethoInterceptor();


    }

    private Interceptor provideCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());

                CacheControl cacheControl = new CacheControl.Builder()
                        .maxAge(1, TimeUnit.MINUTES)
                        .build();

                return response.newBuilder()
                        .header(CACHE_CONTROL, cacheControl.toString())
                        .build();
            }
        };
    }


    @NonNull
    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }


    @Provides
    @Singleton
    public Retrofit provideRetrofitRestAdapter(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public CourseraService provideCourseraApiService(Retrofit restAdapter) {
        return restAdapter.create(CourseraService.class);
    }
}
