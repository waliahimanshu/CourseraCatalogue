package com.waliahimanshu.courseracatalogue.di;


import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.AllCoursesActivity;
import com.waliahimanshu.courseracatalogue.ui.bottomNavigation.AllCoursesFragment;
import com.waliahimanshu.courseracatalogue.ui.home.SearchActivity;
import com.waliahimanshu.courseracatalogue.ui.home.SearchFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {ActivityModule.class, CourseraApiModule.class}
)

public interface ActivityComponent {

    void inject(SearchActivity searchActivity);

    void inject(AllCoursesActivity coursesActivity);

    void inject(AllCoursesFragment allCoursesFragment);

    void inject(SearchFragment searchFragment);
}
