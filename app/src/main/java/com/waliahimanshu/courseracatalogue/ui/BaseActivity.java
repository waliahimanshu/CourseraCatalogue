package com.waliahimanshu.courseracatalogue.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.waliahimanshu.courseracatalogue.api.DebugCourseraApiModule;
import com.waliahimanshu.courseracatalogue.di.TestActivityComponent;
import com.waliahimanshu.courseracatalogue.di.ActivityModule;
import com.waliahimanshu.courseracatalogue.di.DaggerTestActivityComponent;

public abstract class BaseActivity extends AppCompatActivity {

    protected ActivityModule activityModule;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        View view = getWindow().getDecorView();

        activityModule = new ActivityModule(getBaseContext(), view);
//        ActivityComponent activityComponent = DaggerActivityComponent.builder()
//                .courseraApiModule(new CourseraApiModule())
//                .activityModule(activityModule)
//                .build();
//
        TestActivityComponent activityComponent = DaggerTestActivityComponent.builder()
                .debugCourseraApiModule(new DebugCourseraApiModule())
                .activityModule(activityModule)
                .build();



        injectFrom(activityComponent);
        setupActivity(savedInstanceState);

    }

    protected abstract void injectFrom(TestActivityComponent activityComponent);

    protected abstract int getLayoutId();

    abstract protected void setupActivity(Bundle savedInstanceState);

}
