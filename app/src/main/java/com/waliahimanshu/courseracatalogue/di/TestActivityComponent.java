package com.waliahimanshu.courseracatalogue.di;


import com.waliahimanshu.courseracatalogue.api.DebugCourseraApiModule;
import com.waliahimanshu.courseracatalogue.ui.HomeActivity;
import com.waliahimanshu.courseracatalogue.ui.courses.CoursesFragment;
import com.waliahimanshu.courseracatalogue.ui.partners.PartnersFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {ActivityModule.class, DebugCourseraApiModule.class}
)

public interface TestActivityComponent {

    void inject(HomeActivity coursesActivity);

    void inject(CoursesFragment coursesFragment);

    void inject(PartnersFragment partnersFragment);
}
