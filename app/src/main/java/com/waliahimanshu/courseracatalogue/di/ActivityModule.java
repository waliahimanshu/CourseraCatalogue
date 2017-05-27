package com.waliahimanshu.courseracatalogue.di;

import android.content.Context;
import android.view.View;

import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.AllCoursesContract;
import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.AllCoursesPresenter;
import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.AllCoursesView;
import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.LinkedInstructorMapper;
import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.LinkedPartnersMapper;
import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.ResponseMapper;
import com.waliahimanshu.courseracatalogue.ui.home.SearchActivityPresenter;
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




    @Provides
    @Singleton
    public SearchActivityPresenter providesSearchActivityPresenter(AllCoursesContract.View view,
                                                                  CourseraApiService courseraApiService, ResponseMapper responseMapper) {
        return new SearchActivityPresenter(view, courseraApiService, responseMapper);
    }

    @Singleton
    @Provides
    public AllCoursesContract.View providesAllCoursesView() {
        return new AllCoursesView(context, rootView);
    }

    @Singleton
    @Provides
    public ResponseMapper providesResponseMapper() {
        return new ResponseMapper(new LinkedInstructorMapper(), new LinkedPartnersMapper());
    }

    @Provides
    @Singleton
    public AllCoursesContract.Presenter providesAllActivityPresenter( AllCoursesContract.View view, CourseraApiService courseraApiService, ResponseMapper responseMapper) {
        return new AllCoursesPresenter(view, courseraApiService, responseMapper);
    }
}