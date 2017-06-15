package com.waliahimanshu.courseracatalogue.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.waliahimanshu.courseracatalogue.api.CourseraService;
import com.waliahimanshu.courseracatalogue.util.AndroidUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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

        builder.addInterceptor(getHttpLoggingInterceptor());
        builder.addInterceptor(getStethoInterceptor());
        builder.addNetworkInterceptor(getResponseCacheInterceptor());
        builder.addInterceptor(getOfflineResponseInterceptor());
        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        builder.readTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        builder.cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024));

        return builder.build();
    }

    private StethoInterceptor getStethoInterceptor() {
        return new StethoInterceptor();
    }

    /**
     * bug https://github.com/square/okhttp/issues/3174
     */
    private Interceptor getResponseCacheInterceptor() {
        return chain -> {
            Response response = chain.proceed(chain.request());


            CacheControl cacheControl = new CacheControl.Builder()
                    .maxAge(3, TimeUnit.MINUTES)
                    .build();

            return response.newBuilder()
                    .header(CACHE_CONTROL, cacheControl.toString())
                    .build();
        };
    }

    private Interceptor getOfflineResponseInterceptor(){

        return chain -> {
            Request request = chain.request();
            if (!AndroidUtil.isNetworkAvailable(context)) {
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build();

                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();
            }
            return chain.proceed(request);
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
