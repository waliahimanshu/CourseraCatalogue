package com.waliahimanshu.courseracatalogue.Di;

import android.content.Context;
import android.view.View;

import com.waliahimanshu.courseracatalogue.HomeFragmentContract;
import com.waliahimanshu.courseracatalogue.HomeFragmentPresenter;
import com.waliahimanshu.courseracatalogue.HomeFragmentView;
import com.waliahimanshu.courseracatalogue.Service.CourseraApiRestClient;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    private Context context;
    private View rootView;

    public HomeModule(Context context, View rootView) {
        this.context = context;
        this.rootView = rootView;
    }

    @Provides
    public HomeFragmentContract.View providesHomeView() {
        return new HomeFragmentView(context, rootView);
    }

    @Provides
    public CourseraApiRestClient providesRetrofitClient() {
        return new CourseraApiRestClient();
    }


    @Provides
    public HomeFragmentContract.Presenter providesHomePresenter(HomeFragmentView view, CourseraApiRestClient retrofitRestClient) {
        return new HomeFragmentPresenter(view, retrofitRestClient);
    }

}