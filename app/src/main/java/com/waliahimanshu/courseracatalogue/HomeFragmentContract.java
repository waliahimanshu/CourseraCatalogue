package com.waliahimanshu.courseracatalogue;

import com.waliahimanshu.courseracatalogue.Service.Response.Courses;

import java.util.List;

import io.reactivex.Observable;


public interface HomeFragmentContract {

    interface Presenter {
        void unSubscribe();

    }

    interface View {
        void initRecyclerView(List<Courses> courses);

        void setApiCallTextView(int count);

        Observable<String> getSearchViewQueryTextChangesObservable();
    }
}
