package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.api.Response.Courses;
import com.waliahimanshu.courseracatalogue.ui.home.MyAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class AllCoursesView implements AllCoursesContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private Context context;
    private View rootView;

    public AllCoursesView(Context context, View rootView) {

        this.context = context;
        this.rootView = rootView;
        ButterKnife.bind(this, rootView);

    }

    @Override
    public void initRecyclerView(List<Courses> courses) {

        MyAdapter adapter = new MyAdapter(context, courses);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void showProgressBar(boolean show) {

    }

    @Override
    public void showError() {

    }
}
