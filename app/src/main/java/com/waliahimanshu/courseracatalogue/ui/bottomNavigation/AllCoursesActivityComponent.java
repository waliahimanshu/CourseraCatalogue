package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;


import com.waliahimanshu.courseracatalogue.di.CourseraApiModule;
import com.waliahimanshu.courseracatalogue.ui.home.HomeActivity;
import com.waliahimanshu.courseracatalogue.ui.home.HomeFragment;
import com.waliahimanshu.courseracatalogue.ui.home.HomeModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {AllCoursesModule.class, CourseraApiModule.class}
)

public interface AllCoursesActivityComponent {

    void inject(AllCoursesActivity coursesActivity);
}
