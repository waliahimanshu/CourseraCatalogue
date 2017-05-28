package com.waliahimanshu.courseracatalogue.ui.all_courses;

import com.waliahimanshu.courseracatalogue.ui.all_courses.domain.CourseDetailsDomain;

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
