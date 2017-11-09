package com.waliahimanshu.courseracatalogue.ui.search;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by himanshuw on 02/11/2017.
 */

public class RxTest {

    @Test// return Observable if need to chain multiple operators
    public void flatMap() throws Exception {
        Observable.fromArray("Hello World", "Whats up")
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(String s) throws Exception {
                        return Observable.fromArray(s.split(" "));
                    }
                }).subscribe(System.out::print);

    }
}
