package com.waliahimanshu.courseracatalogue.ui.home;

import android.util.Log;

import com.waliahimanshu.courseracatalogue.api.CourseraApiService;
import com.waliahimanshu.courseracatalogue.api.Response.Courses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
    private static String TAG = HomeFragmentPresenter.class.getSimpleName();
    private HomeFragmentContract.View fragmentView;
    private CourseraApiService courseraApiService;
    private int noOfApiCalls = 0;
    private Disposable disposable;

    @Inject
    public HomeFragmentPresenter(HomeFragmentContract.View fragmentView, CourseraApiService courseraApiService) {
        this.fragmentView = fragmentView;
        this.courseraApiService = courseraApiService;
        init();

    }

    private void init() {
        Log.d(TAG, "Observable listener is registered");
        disposable = fragmentView.getSearchViewQueryTextChangesObservable()
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
               .doOnSubscribe(x -> fragmentView.showProgressBar(true))
                .switchMap(q -> courseraApiService.search(q).toObservable())
                .map(resp -> resp.courses)
//                .doFinally(() -> fragmentView.showProgressBar(false))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(courses -> {
                    fragmentView.setApiCallTextView(noOfApiCalls++);
                    fragmentView.initRecyclerView(courses);
                });

    }

    private void showResults(List<Courses> courses) {
        fragmentView.setApiCallTextView(noOfApiCalls++);
        fragmentView.initRecyclerView(courses);
    }

    //region [Example : using Single]

    /*
    Single.fromCallable(() -> new CourseraApiRestClient().search(query).execute().body().courses)
         .subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe(
             new SingleObserver<List<Courses>>() {

               @Override
               public void onSubscribe(Disposable disposable) {}

               @Override
               public void onSuccess(List<Courses> courses) {

                 fragmentView.initRecyclerView(courses);
                 fragmentView.setApiCallTextView(noOfApiCalls++);
               }

               @Override
               public void onError(Throwable throwable) {}
             });

    */
    //endregion

    //region [Example using FromCallable]

    /*
        Observable.fromCallable(() -> new CourseraApiRestClient().search(query).execute().body().courses)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                new Observer<List<Courses>>() {
                  @Override
                  public void onSubscribe(Disposable disposable) {

                    Log.d(TAG, "onSubscribe called");
                  }

                  @Override
                  public void onNext(List<Courses> courses) {
                    fragmentView.initRecyclerView(courses);
                  }

                  @Override
                  public void onError(Throwable throwable) {}

                  @Override
                  public void onComplete() {
                    Log.d(TAG, "onComplete called");
                  }
                });
    */
    //endregion


    @Override
    public void unSubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            Log.d(TAG, "Disposable unSubscribed");
            disposable.dispose();
            disposable = null;
        }
    }

}
