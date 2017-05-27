package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;

import com.waliahimanshu.courseracatalogue.ui.home.CourseDetailsDomain;

import java.util.List;

public interface AllCoursesContract {

    interface Presenter {
        void getData();

    }

    interface View {
        void initRecyclerView(List<CourseDetailsDomain> courses);

        void showProgressBar(boolean show);

        void showError();

        void setApiCallTextView(int i);
    }
}
