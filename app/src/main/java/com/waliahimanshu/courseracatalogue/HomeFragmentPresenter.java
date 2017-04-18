package com.waliahimanshu.courseracatalogue;

import android.util.Log;

import com.waliahimanshu.courseracatalogue.Service.RetrofitRestClient;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
    private static String TAG = HomeFragmentPresenter.class.getSimpleName();
    private HomeFragmentView fragmentView;
    private RetrofitRestClient retrofitRestClient;
    private int noOfApiCalls = 0;
    private Disposable disposable;

    HomeFragmentPresenter(HomeFragmentView fragmentView, RetrofitRestClient retrofitRestClient) {
        this.fragmentView = fragmentView;
        this.retrofitRestClient = retrofitRestClient;
        init();

    }

    private void init() {
        Log.d(TAG, "Observable listener is registered");
        disposable = fragmentView.getSearchViewQueryTextChangesObservable()
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .switchMap(q -> retrofitRestClient.search(q).toObservable())
                .map(resp -> resp.courses)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(courses -> {
                    fragmentView.setApiCallTextView(noOfApiCalls++);
                    fragmentView.initRecyclerView(courses);
                }, Throwable::printStackTrace);
    }

    //region [Example : using Single]

    /*
    Single.fromCallable(() -> new RetrofitRestClient().search(query).execute().body().courses)
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
        Observable.fromCallable(() -> new RetrofitRestClient().search(query).execute().body().courses)
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
            Log.d(TAG,"Disposable unSubscribed");
            disposable.dispose();
            disposable = null;
        }
    }

}
