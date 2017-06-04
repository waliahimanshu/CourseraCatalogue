package com.waliahimanshu.courseracatalogue.ui.courses;


import com.waliahimanshu.courseracatalogue.api.CourseraService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CoursesPresenter implements CoursesContract.Presenter {

    private CourseraService apiService;
    private CoursesContract.View view;
    private CoursesDetailDomainMapper responseMapper;

    @Inject
    public CoursesPresenter(CoursesContract.View view, CourseraService apiService, CoursesDetailDomainMapper responseMapper) {
        this.apiService = apiService;
        this.view = view;
        this.responseMapper = responseMapper;
    }

    @Override
    public void getData() {
        apiService.getAllCourses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(responseMapper)
                .subscribe(courseDetailsDomains -> view.initRecyclerView(courseDetailsDomains));

    }
}

