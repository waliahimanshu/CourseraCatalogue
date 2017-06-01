package com.waliahimanshu.courseracatalogue.ui.all_courses;


import android.os.Bundle;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.di.TestActivityComponent;
import com.waliahimanshu.courseracatalogue.ui.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class AllCoursesActivity extends BaseActivity {

    @Inject
    AllCoursesPresenter presenter;

    @Override
    protected void injectFrom(TestActivityComponent activityComponent) {
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

