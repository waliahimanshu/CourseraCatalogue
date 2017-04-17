package com.waliahimanshu.courseracatalogue;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.waliahimanshu.courseracatalogue.Service.Courses;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class HomeFragmentView implements HomeFragmentContract.View {
  private Context baseContext;
  private View view;

  @BindView(R.id.recycler_view)
  RecyclerView recyclerView;

  @BindView(R.id.no_of_api_calls)
  TextView noOfApiCalls;

  public HomeFragmentView(Context baseContext, View view) {
    this.baseContext = baseContext;
    this.view = view;
    ButterKnife.bind(this, view);
  }

  @Override
  public void initRecyclerView(List<Courses> courses) {
    setUpRecyclerView(courses);
  }

    @Override
    public void setApiCallTextView(int count) {
        noOfApiCalls.setText("API CALLS :` "+count);
    }

    private void setUpRecyclerView(List<Courses> courses) {
    MyAdapter adapter = new MyAdapter(baseContext, courses);
    recyclerView.setAdapter(adapter);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseContext);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(linearLayoutManager);
  }
}
