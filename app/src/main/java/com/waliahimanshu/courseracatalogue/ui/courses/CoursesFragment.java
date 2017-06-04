package com.waliahimanshu.courseracatalogue.ui.courses;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.di.ActivityModule;
import com.waliahimanshu.courseracatalogue.di.CourseraApiModule;
import com.waliahimanshu.courseracatalogue.di.DaggerActivityComponent;
import com.waliahimanshu.courseracatalogue.ui.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class CoursesFragment extends BaseFragment {

    @Inject
    CoursesPresenter presenter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getFragmentId(), container, false);
        ButterKnife.bind(this, view);

        activityModule = new ActivityModule(getContext(), view);

//        TestActivityComponent activityComponent = DaggerTestActivityComponent.builder()
//                .debugCourseraApiModule(new DebugCourseraApiModule())
//                .activityModule(activityModule)
//                .build();



      ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .courseraApiModule(new CourseraApiModule())
                .activityModule(activityModule)
                .build();



        injectFrom(activityComponent);

        setUpFragment();
        return view;
    }

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void setUpFragment() {
        presenter.getData();

    }
    @Override
    protected View getFragmentView() {
        return view;
    }



    @Override
    protected int getFragmentId() {
        return R.layout.courses_fragment;
    }
}
