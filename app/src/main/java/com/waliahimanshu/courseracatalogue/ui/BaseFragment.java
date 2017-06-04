package com.waliahimanshu.courseracatalogue.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.waliahimanshu.courseracatalogue.api.DebugCourseraApiModule;
import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.di.ActivityModule;
import com.waliahimanshu.courseracatalogue.di.DaggerTestActivityComponent;
import com.waliahimanshu.courseracatalogue.di.TestActivityComponent;

public abstract class BaseFragment extends Fragment {

    protected ActivityModule activityModule;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        TestActivityComponent activityComponent = DaggerTestActivityComponent.builder()
//                .debugCourseraApiModule(new DebugCourseraApiModule())
//                .activityModule(activityModule)
//                .build();
//
//        injectFrom(activityComponent);

    }
    protected abstract void injectFrom(ActivityComponent activityComponent);


    protected abstract void setUpFragment( );

    protected abstract View getFragmentView( );

    protected abstract int getFragmentId();
}
