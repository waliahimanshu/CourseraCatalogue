package com.waliahimanshu.courseracatalogue.di;


import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.AllCoursesActivity;
import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.AllCoursesFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {ActivityModule.class, CourseraApiModule.class}
)

public interface ActivityComponent {


    void inject(AllCoursesActivity coursesActivity);

    void inject(AllCoursesFragment allCoursesFragment);

}
