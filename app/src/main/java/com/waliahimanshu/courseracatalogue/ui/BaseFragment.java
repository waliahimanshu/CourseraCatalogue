package com.waliahimanshu.courseracatalogue.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.di.ActivityModule;

public abstract class BaseFragment extends Fragment {

    protected ActivityModule activityModule;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        activityModule = new ActivityModule(getContext(),);
//        ActivityComponent activityComponent = DaggerActivityComponent.builder()
//                .courseraApiModule(new CourseraApiModule())
//                .activityModule(activityModule)
//                .build();

    }
    protected abstract void injectFrom(ActivityComponent activityComponent);


    protected abstract void setUpFragment( );

    protected abstract int getFragmentId();
}
