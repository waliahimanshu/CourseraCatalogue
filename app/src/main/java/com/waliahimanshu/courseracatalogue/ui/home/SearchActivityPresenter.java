package com.waliahimanshu.courseracatalogue.ui.home;

import android.util.Log;

import com.waliahimanshu.courseracatalogue.api.CourseraApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchActivityPresenter implements SearchActivityContract.Presenter {
    private static String TAG = SearchActivityPresenter.class.getSimpleName();
    private SearchActivityContract.View fragmentView;
    private CourseraApiService courseraApiService;
    private int noOfApiCalls = 0;
    private Disposable disposable;

    @Inject
    public SearchActivityPresenter(SearchActivityContract.View fragmentView, CourseraApiService courseraApiService) {
        this.fragmentView = fragmentView;
        this.courseraApiService = courseraApiService;
        init();

    }

    private void init() {
        Log.d(TAG, "Observable listener is registered");
        disposable = fragmentView.getSearchViewQueryTextChangeSubject()
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(x -> fragmentView.showProgressBar(true))
                .observeOn(Schedulers.io())
                .switchMap(q -> courseraApiService.search(q).toObservable())
                .map(resp -> resp.courses)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(courses -> {
                    fragmentView.setApiCallTextView(++noOfApiCalls);
                    fragmentView.initRecyclerView(courses);
                    fragmentView.showProgressBar(false);

                });
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
