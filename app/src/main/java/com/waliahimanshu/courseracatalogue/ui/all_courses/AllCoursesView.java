package com.waliahimanshu.courseracatalogue.ui.all_courses;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.ui.all_courses.domain.CourseDetailsDomain;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllCoursesView implements AllCoursesContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @BindView(R.id.no_of_api_calls)
    TextView noOfApiCalls;


    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private Context context;

    public AllCoursesView(Context context, View rootView) {

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
        noOfApiCalls.setText(String.format(Locale.getDefault(),
                "%s%d", context.getString(R.string.no_of_api_calls), count));
    }

    @Override
    public void showProgressBar(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError() {

    }
}
