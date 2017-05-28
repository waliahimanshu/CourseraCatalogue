package com.waliahimanshu.courseracatalogue.ui.all_courses;


import com.waliahimanshu.courseracatalogue.api.CourseraApiService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AllCoursesPresenter implements AllCoursesContract.Presenter {

    private CourseraApiService apiService;
    private AllCoursesContract.View view;
    private CoursesDetailDomainMapper responseMapper;

    @Inject
    public AllCoursesPresenter(AllCoursesContract.View view, CourseraApiService apiService, CoursesDetailDomainMapper responseMapper) {
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

