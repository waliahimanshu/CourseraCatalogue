package com.waliahimanshu.courseracatalogue;

import android.support.v7.widget.SearchView;

import com.waliahimanshu.courseracatalogue.Service.Courses;

import java.util.List;

public interface HomeFragmentContract {

  interface Presenter {
    void onQueryTextChange(String query);

    void unSubscribe();
  }

  interface View {
    void initRecyclerView(List<Courses> courses);

      void setApiCallTextView(int count);
  }
}
