package com.waliahimanshu.courseracatalogue.ui.search;

import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class RxSearch {
    public static Observable<String> fromSearchView(@NonNull final SearchView searchView) {
        final BehaviorSubject<String> subject = BehaviorSubject.create();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.isEmpty()) {
                    subject.onNext(newText);
                }
                return true;
            }
        });
        return subject;
    }
}