package com.waliahimanshu.courseracatalogue.di;


import com.waliahimanshu.courseracatalogue.ui.Home.HomeFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {HomeModule.class, CourseraApiModule.class}
)

public interface HomeActivityComponent {

    void inject(HomeFragment homeFragment);
}
