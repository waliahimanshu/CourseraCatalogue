package com.waliahimanshu.courseracatalogue.ui;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.di.TestActivityComponent;
import com.waliahimanshu.courseracatalogue.ui.BaseActivity;
import com.waliahimanshu.courseracatalogue.ui.HomeActivityPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.sliding_tabs_layout)
    TabLayout tabLayout;

    @BindView(R.id.search_view_widget)
    View searchView;


    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_activity;
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        HomeActivityPagerAdapter myPagerAdapter = new HomeActivityPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}

