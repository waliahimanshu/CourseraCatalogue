package com.waliahimanshu.courseracatalogue;

import com.waliahimanshu.courseracatalogue.Service.Courses;
import com.waliahimanshu.courseracatalogue.Service.RetrofitRestClient;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
  private static String TAG = HomeFragmentPresenter.class.getSimpleName();
  private HomeFragmentView fragmentView;

  public HomeFragmentPresenter(HomeFragmentView fragmentView) {
    this.fragmentView = fragmentView;
  }

  @Override
  public void loadData(String query) {

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

              }

              @Override
              public void onError(Throwable throwable) {}
            });




//    Observable.fromCallable(() -> new RetrofitRestClient().search(query).execute().body().courses)
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(
//            new Observer<List<Courses>>() {
//              @Override
//              public void onSubscribe(Disposable disposable) {
//
//                Log.d(TAG, "onSubscribe called");
//              }
//
//              @Override
//              public void onNext(List<Courses> courses) {
//                fragmentView.initRecyclerView(courses);
//              }
//
//              @Override
//              public void onError(Throwable throwable) {}
//
//              @Override
//              public void onComplete() {
//                Log.d(TAG, "onComplete called");
//              }
//            });
  }

  @Override
  public void unSubscribe() {}
}
