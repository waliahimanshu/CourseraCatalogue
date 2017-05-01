package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;


import com.waliahimanshu.courseracatalogue.api.CourseraApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AllCoursesPresenter implements AllCoursesContract.Presenter {


    private CourseraApiService apiService;
    private AllCoursesContract.View view;

    public AllCoursesPresenter(AllCoursesContract.View view, CourseraApiService apiService) {
        this.apiService = apiService;
        this.view = view;

        getData();
    }

    private void getData() {
        apiService.getAllCourses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(x -> view.showProgressBar(true))
//                .doFinally(y -> view.showProgressBar(false))
                .map(coursesResponse -> coursesResponse.courses)
                .subscribe(courses -> {
                            view.initRecyclerView(courses);
                            view.showProgressBar(false);
                        }
                );

    }

    @Override
    public void unSubscribe() {

    }
}
