package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;


import android.content.Context;
import android.view.View;

import com.waliahimanshu.courseracatalogue.api.Response.Courses;

import java.util.List;

import io.reactivex.Observable;

public class AllCoursesView implements AllCoursesContract.View {

    private Context context;
    private View rootView;

    public AllCoursesView(Context context, View rootView) {

        this.context = context;
        this.rootView = rootView;
    }

    @Override
    public void initRecyclerView(List<Courses> courses) {

    }

    @Override
    public void showProgressBar(boolean show) {

    }

    @Override
    public void showError() {

    }
}
