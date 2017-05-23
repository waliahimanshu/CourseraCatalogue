package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;


import com.waliahimanshu.courseracatalogue.api.CourseraApiService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AllCoursesPresenter implements AllCoursesContract.Presenter {


    private CourseraApiService apiService;
    private AllCoursesContract.View view;

    @Inject
    public AllCoursesPresenter(AllCoursesContract.View view, CourseraApiService apiService) {
        this.apiService = apiService;
        this.view = view;

    }

    @Override
    public void getData() {

        apiService.getAllCourses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(coursesResponse -> coursesResponse.courses)
                .subscribe(courses -> view.initRecyclerView(courses)
                );

    }
}

