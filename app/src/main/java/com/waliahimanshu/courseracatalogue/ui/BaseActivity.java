package com.waliahimanshu.courseracatalogue.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.di.ActivityModule;
import com.waliahimanshu.courseracatalogue.di.CourseraApiModule;
import com.waliahimanshu.courseracatalogue.di.DaggerActivityComponent;

public abstract class BaseActivity extends AppCompatActivity {

    protected ActivityModule activityModule;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        View view = getWindow().getDecorView();

        activityModule = new ActivityModule(getBaseContext(), view);
        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .courseraApiModule(new CourseraApiModule())
                .activityModule(activityModule)
                .build();

        injectFrom(activityComponent);
        setupActivity(savedInstanceState);

    }

    protected abstract void injectFrom(ActivityComponent activityComponent);

    protected abstract int getLayoutId();

    abstract protected void setupActivity(Bundle savedInstanceState);

}
