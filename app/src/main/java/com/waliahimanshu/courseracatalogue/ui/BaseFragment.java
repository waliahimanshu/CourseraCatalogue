package com.waliahimanshu.courseracatalogue.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.di.ActivityModule;
import com.waliahimanshu.courseracatalogue.di.CourseraApiModule;
import com.waliahimanshu.courseracatalogue.di.DaggerActivityComponent;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    protected ActivityModule activityModule;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .courseraApiModule(new CourseraApiModule())
                .activityModule(activityModule)
                .build();

        View view = inflater.inflate(getFragmentId(), container, false);

        injectFrom(activityComponent);
        setupFragment(savedInstanceState);
        return view;

    }

    protected abstract void injectFrom(ActivityComponent activityComponent);

    protected abstract int getFragmentId();

    protected abstract int getFragmentView();


    abstract protected void setupFragment(Bundle savedInstanceState);

}
