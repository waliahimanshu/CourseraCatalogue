package com.waliahimanshu.courseracatalogue.di;


import com.waliahimanshu.courseracatalogue.api.DebugCourseraApiModule;
import com.waliahimanshu.courseracatalogue.di.ActivityModule;
import com.waliahimanshu.courseracatalogue.ui.all_courses.AllCoursesActivity;
import com.waliahimanshu.courseracatalogue.ui.all_courses.AllCoursesFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {ActivityModule.class, DebugCourseraApiModule.class}
)

public interface TestActivityComponent {

    void inject(AllCoursesActivity coursesActivity);

    void inject(AllCoursesFragment allCoursesFragment);
}
