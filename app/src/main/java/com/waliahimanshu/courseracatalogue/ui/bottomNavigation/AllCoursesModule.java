package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;

import android.content.Context;
import android.view.View;

import com.waliahimanshu.courseracatalogue.api.CourseraApiService;
import com.waliahimanshu.courseracatalogue.ui.home.HomeFragmentContract;
import com.waliahimanshu.courseracatalogue.ui.home.HomeFragmentPresenter;
import com.waliahimanshu.courseracatalogue.ui.home.HomeFragmentView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AllCoursesModule {
    private Context context;
    private View rootView;

    public AllCoursesModule(Context context, View rootView) {
        this.context = context;
        this.rootView = rootView;
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