package com.waliahimanshu.courseracatalogue.ui.courses;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.ui.domain.CourseDetailsDomain;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoursesView implements CoursesContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private Context context;

    public CoursesView(Context context, View rootView) {
        this.context = context;
        ButterKnife.bind(this, rootView);

    }

    @Override
    public void initRecyclerView(List<CourseDetailsDomain> courses) {
        CoursesInfoAdapter adapter = new CoursesInfoAdapter(context, courses);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void setApiCallTextView(int count) {
    }

    @Override
    public void showProgressBar(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError() {

    }
}
