package com.waliahimanshu.courseracatalogue.ui.search;

import android.util.Log;

import com.waliahimanshu.courseracatalogue.api.CourseraApiService;
import com.waliahimanshu.courseracatalogue.ui.all_courses.AllCoursesContract;
import com.waliahimanshu.courseracatalogue.ui.all_courses.CoursesDetailDomainMapper;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchActivityPresenter {
    private static String TAG = SearchActivityPresenter.class.getSimpleName();
    private AllCoursesContract.View view;
    private CourseraApiService courseraApiService;
    private CoursesDetailDomainMapper responseMapper;
    private int noOfApiCalls = 0;
    private Disposable disposable;

    @Inject
    public SearchActivityPresenter(AllCoursesContract.View view, CourseraApiService courseraApiService, CoursesDetailDomainMapper responseMapper) {
        this.view = view;
        this.courseraApiService = courseraApiService;
        this.responseMapper = responseMapper;
    }

    public void init(Observable<String> stringObservable) {
        Log.d(TAG, "Observable listener is registered");
        disposable = stringObservable
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(x -> view.showProgressBar(true))
                .observeOn(Schedulers.io())
                .switchMap(q -> courseraApiService.search(q).toObservable())
                .map(responseMapper)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> {
                    String message = throwable.getMessage();
                    Log.e("Critical error", message);
                })
                .subscribe(courses -> {
                    view.setApiCallTextView(++noOfApiCalls);
                    view.initRecyclerView(courses);
                    view.showProgressBar(false);

                });
    }

    public void unSubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            Log.d(TAG, "Disposable unSubscribed");
            disposable.dispose();
            disposable = null;
        }
    }

}
