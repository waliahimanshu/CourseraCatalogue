package com.waliahimanshu.courseracatalogue.ui.all_courses;


import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.ui.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class AllCoursesActivity extends BaseActivity {

    @Inject
    AllCoursesPresenter presenter;

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.all_courses_activity;
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        presenter.getData();
    }
}

