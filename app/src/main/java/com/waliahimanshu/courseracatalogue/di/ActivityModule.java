package com.waliahimanshu.courseracatalogue.di;

import android.content.Context;
import android.view.View;

import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.AllCoursesContract;
import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.AllCoursesPresenter;
import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.AllCoursesView;
import com.waliahimanshu.courseracatalogue.ui.home.SearchActivityContract;
import com.waliahimanshu.courseracatalogue.ui.home.SearchActivityPresenter;
import com.waliahimanshu.courseracatalogue.ui.home.SearchActivityView;
import com.waliahimanshu.courseracatalogue.api.CourseraApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Context context;
    private View rootView;

    public ActivityModule(Context context, View rootView) {
        this.context = context;
        this.rootView = rootView;
    }

    @Singleton
    @Provides
    public SearchActivityContract.View providesHomeView() {
        return new SearchActivityView(context, rootView);
    }


    @Provides
    @Singleton
    public SearchActivityContract.Presenter providesHomePresenter(SearchActivityContract.View view,
                                                                  CourseraApiService courseraApiService) {
        return new SearchActivityPresenter(view, courseraApiService);
    }

    @Singleton
    @Provides
    public AllCoursesContract.View providesAllCoursesView() {
        return new AllCoursesView(context, rootView);
    }


    @Provides
    @Singleton
    public AllCoursesContract.Presenter providesAllActivityPresenter( AllCoursesContract.View view, CourseraApiService courseraApiService) {
        return new AllCoursesPresenter(view, courseraApiService);
    }
}