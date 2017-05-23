package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;

import com.waliahimanshu.courseracatalogue.api.Response.Courses;

import java.util.List;

public interface AllCoursesContract {

    interface Presenter {
        void getData();

    }

    interface View {
        void initRecyclerView(List<Courses> courses);

        void showProgressBar(boolean show);

        void showError();

        void setApiCallTextView(int i);
    }
}
