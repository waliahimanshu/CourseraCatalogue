package com.waliahimanshu.courseracatalogue;

class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
  private static String TAG = HomeFragmentPresenter.class.getSimpleName();
  private HomeFragmentView fragmentView;
  private int noOfApiCalls = 0;

  public HomeFragmentPresenter(HomeFragmentView fragmentView) {
    this.fragmentView = fragmentView;
  }

  @Override
  public void onQueryTextChange(String searchText) {

//      PublishSubject<String> subjectBus = PublishSubject.create();
//        subject.debounce(300, TimeUnit.MILLISECONDS)
//        .observeOn(Schedulers.io())
//        .flatMap(new Function<String, ObservableSource<List<Courses>>>() {
//            @Override
//            public ObservableSource<List<Courses>> apply(String searchText) throws Exception {
//                return Observable.fromCallable(new Callable<List<Courses>>() {
//                    @Override
//                    public List<Courses> call() throws Exception {
//                        return new RetrofitRestClient().search(searchText).execute().body().courses;
//                    }
//                });
//            }
//        }).subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Consumer<List<Courses>>() {
//            @Override
//            public void accept(List<Courses> courses) throws Exception {
//                fragmentView.initRecyclerView(courses);
//                fragmentView.setApiCallTextView(noOfApiCalls++);
//            }
//        });


      //    Single.fromCallable(() -> new RetrofitRestClient().search(query).execute().body().courses)
    //        .subscribeOn(Schedulers.io())
    //        .observeOn(AndroidSchedulers.mainThread())
    //        .subscribe(
    //            new SingleObserver<List<Courses>>() {
    //
    //              @Override
    //              public void onSubscribe(Disposable disposable) {}
    //
    //              @Override
    //              public void onSuccess(List<Courses> courses) {
    //
    //                fragmentView.initRecyclerView(courses);
    //                fragmentView.setApiCallTextView(noOfApiCalls++);
    //              }
    //
    //              @Override
    //              public void onError(Throwable throwable) {}
    //            });

    //begin region
    //
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
    //
    //end region
  }

  @Override
  public void unSubscribe() {}
}
