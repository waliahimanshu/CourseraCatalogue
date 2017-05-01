package com.waliahimanshu.courseracatalogue.ui.home;


import com.waliahimanshu.courseracatalogue.di.CourseraApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {HomeModule.class, CourseraApiModule.class}
)

public interface HomeActivityComponent {

    void inject(HomeFragment homeFragment);
}
