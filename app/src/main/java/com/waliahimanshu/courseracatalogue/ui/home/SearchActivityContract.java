package com.waliahimanshu.courseracatalogue.ui.home;

import com.waliahimanshu.courseracatalogue.api.Response.Courses;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public interface SearchActivityContract {

    interface Presenter {
        void unSubscribe();

    }

    interface View {
        void initRecyclerView(List<Courses> courses);

        void setApiCallTextView(int count);

        Observable<String> getSearchViewQueryTextChangeSubject();

        void showProgressBar(boolean show);

        void showError();
    }
}
