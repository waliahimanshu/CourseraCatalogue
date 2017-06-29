package com.waliahimanshu.courseracatalogue.ui.instructors;


import com.waliahimanshu.courseracatalogue.api.CourseraService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class InstructorPresenter implements InstructorContract.Presenter {

    private CourseraService apiService;
    private InstructorContract.View view;
    private InstructorDetailsDomainMapper responseMapper;

    @Inject
    public InstructorPresenter(InstructorContract.View view, CourseraService apiService, InstructorDetailsDomainMapper responseMapper) {
        this.apiService = apiService;
        this.view = view;
        this.responseMapper = responseMapper;
    }

    @Override
    public void getData() {
        apiService.getInstructors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(responseMapper)
                .subscribe(courseDetailsDomains -> view.initRecyclerView(courseDetailsDomains));

    }
}

