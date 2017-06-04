package com.waliahimanshu.courseracatalogue.ui.courses;

import com.waliahimanshu.courseracatalogue.ui.domain.CourseDetailsDomain;

import java.util.List;

public interface CoursesContract {

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
