package com.waliahimanshu.courseracatalogue;

import com.waliahimanshu.courseracatalogue.Service.Courses;

import java.util.List;

public interface HomeFragmentContract {

  interface Presenter {
    void loadData(String query);

    void unSubscribe();
  }

  interface View {
    void initRecyclerView(List<Courses> courses);
  }
}
