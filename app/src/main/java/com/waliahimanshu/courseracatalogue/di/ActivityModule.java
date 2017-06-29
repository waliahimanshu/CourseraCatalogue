package com.waliahimanshu.courseracatalogue.di;

import android.content.Context;
import android.view.View;

import com.waliahimanshu.courseracatalogue.api.CourseraService;
import com.waliahimanshu.courseracatalogue.ui.courses.CoursesContract;
import com.waliahimanshu.courseracatalogue.ui.courses.CoursesPresenter;
import com.waliahimanshu.courseracatalogue.ui.courses.CoursesView;
import com.waliahimanshu.courseracatalogue.ui.domain.InstructorDetailsDomain;
import com.waliahimanshu.courseracatalogue.ui.instructors.InstructorContract;
import com.waliahimanshu.courseracatalogue.ui.instructors.InstructorDetailsDomainMapper;
import com.waliahimanshu.courseracatalogue.ui.instructors.InstructorPresenter;
import com.waliahimanshu.courseracatalogue.ui.instructors.InstructorView;
import com.waliahimanshu.courseracatalogue.ui.partners.PartnersContract;
import com.waliahimanshu.courseracatalogue.ui.partners.PartnersPresenter;
import com.waliahimanshu.courseracatalogue.ui.partners.PartnersView;
import com.waliahimanshu.courseracatalogue.ui.courses.CoursesDetailDomainMapper;
import com.waliahimanshu.courseracatalogue.ui.courses.LinkedInstructorMapper;
import com.waliahimanshu.courseracatalogue.ui.courses.LinkedPartnersMapper;
import com.waliahimanshu.courseracatalogue.ui.partners.PartnerDetailsDomainMapper;
import com.waliahimanshu.courseracatalogue.ui.search.SearchActivityPresenter;

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
    public SearchActivityPresenter providesSearchActivityPresenter(CoursesContract.View view,
                                                                   CourseraService courseraService, CoursesDetailDomainMapper responseMapper) {
        return new SearchActivityPresenter(view, courseraService, responseMapper);
    }

    @Singleton
    @Provides
    public CoursesContract.View providesAllCoursesView() {
        return new CoursesView(context, rootView);
    }

    @Singleton
    @Provides
    public CoursesDetailDomainMapper providesResponseMapper() {
        return new CoursesDetailDomainMapper(new LinkedInstructorMapper(), new LinkedPartnersMapper());
    }

    @Provides
    @Singleton
    public CoursesContract.Presenter providesAllActivityPresenter(CoursesContract.View view, CourseraService courseraService, CoursesDetailDomainMapper responseMapper) {
        return new CoursesPresenter(view, courseraService, responseMapper);
    }


    @Singleton
    @Provides
    public PartnerDetailsDomainMapper providesPartnerMapper() {
        return new PartnerDetailsDomainMapper();
    }

    @Singleton
    @Provides
    public PartnersContract.View providesAllPartnerView() {
        return new PartnersView(context, rootView);
    }


    @Provides
    @Singleton
    public PartnersContract.Presenter providesAllPartnerPresenter(PartnersContract.View view, CourseraService courseraService, PartnerDetailsDomainMapper responseMapper) {
        return new PartnersPresenter(view, courseraService, responseMapper);
    }

    @Singleton
    @Provides
    public InstructorContract.View providesAllInstructorView() {
        return new InstructorView(context, rootView);
    }


    @Provides
    @Singleton
    public InstructorContract.Presenter providesAllInstructorPresenter(InstructorContract.View view, CourseraService courseraService, InstructorDetailsDomainMapper instructorDetailsDomainMapper) {
        return new InstructorPresenter(view, courseraService, instructorDetailsDomainMapper);
    }
}