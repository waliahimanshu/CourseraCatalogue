package com.waliahimanshu.courseracatalogue.ui.home;

import android.content.Context;
import android.view.View;

import com.waliahimanshu.courseracatalogue.ui.home.HomeFragmentContract;
import com.waliahimanshu.courseracatalogue.ui.home.HomeFragmentPresenter;
import com.waliahimanshu.courseracatalogue.ui.home.HomeFragmentView;
import com.waliahimanshu.courseracatalogue.api.CourseraApiService;

import javax.inject.Singleton;

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

    @Singleton
    @Provides
    public HomeFragmentContract.View providesHomeView() {
        return new HomeFragmentView(context, rootView);
    }


    @Provides
    @Singleton
    public HomeFragmentContract.Presenter providesHomePresenter( HomeFragmentContract.View view, CourseraApiService courseraApiService) {
        return new HomeFragmentPresenter(view, courseraApiService);
    }
}