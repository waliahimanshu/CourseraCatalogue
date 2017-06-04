package com.waliahimanshu.courseracatalogue.di;


import com.waliahimanshu.courseracatalogue.ui.HomeActivity;
import com.waliahimanshu.courseracatalogue.ui.courses.CoursesFragment;
import com.waliahimanshu.courseracatalogue.ui.partners.PartnersFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {ActivityModule.class, CourseraApiModule.class}
)

public interface ActivityComponent {

    void inject(HomeActivity coursesActivity);

    void inject(CoursesFragment coursesFragment);

    void inject(PartnersFragment partnersFragment);
}
