package com.waliahimanshu.courseracatalogue.di;

import android.content.Context;
import android.view.View;

import com.waliahimanshu.courseracatalogue.ui.all_courses.AllCoursesContract;
import com.waliahimanshu.courseracatalogue.ui.all_courses.AllCoursesPresenter;
import com.waliahimanshu.courseracatalogue.ui.all_courses.AllCoursesView;
import com.waliahimanshu.courseracatalogue.ui.all_courses.LinkedInstructorMapper;
import com.waliahimanshu.courseracatalogue.ui.all_courses.LinkedPartnersMapper;
import com.waliahimanshu.courseracatalogue.ui.all_courses.CoursesDetailDomainMapper;
import com.waliahimanshu.courseracatalogue.ui.search.SearchActivityPresenter;
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
                                                                  CourseraApiService courseraApiService, CoursesDetailDomainMapper responseMapper) {
        return new SearchActivityPresenter(view, courseraApiService, responseMapper);
    }

    @Singleton
    @Provides
    public AllCoursesContract.View providesAllCoursesView() {
        return new AllCoursesView(context, rootView);
    }

    @Singleton
    @Provides
    public CoursesDetailDomainMapper providesResponseMapper() {
        return new CoursesDetailDomainMapper(new LinkedInstructorMapper(), new LinkedPartnersMapper());
    }

    @Provides
    @Singleton
    public AllCoursesContract.Presenter providesAllActivityPresenter( AllCoursesContract.View view, CourseraApiService courseraApiService, CoursesDetailDomainMapper responseMapper) {
        return new AllCoursesPresenter(view, courseraApiService, responseMapper);
    }
}