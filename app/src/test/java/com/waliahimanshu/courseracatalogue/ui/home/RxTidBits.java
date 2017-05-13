package com.waliahimanshu.courseracatalogue.ui.home;

import org.junit.Test;

import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class RxTidBits {

    //Observable produce items
    // Subscriber consumes
    //action on Next() *2  onComplete and onError *1

    // operators

    //Schedulers


    @Test
    public void map() throws Exception {
        Observable.fromArray(1, 3, 4)
                .map(integer -> Integer.toString(integer).split(" "))
                .subscribe(x-> System.out.print(Arrays.toString(x)));

    }

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

    @Test
    public void filter() throws Exception {
        Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(integer -> integer % 2 == 1)
                .subscribe(System.out::print);

    }

    @Test// multiple api calls and need to tie the response together
    public void zip() throws Exception {
        Observable<Integer> obser1 = Observable.just(1, 2, 3, 4);
        Observable<String> obser2 = Observable.just("one", "two", "three");

        Observable.zip(obser1, obser2, (integer, s) -> new MyCustomType(integer,s))
        .subscribe(x ->
            System.out.println("SubscribeValue = " + x.toString()
            ));


    }

    @Test
    public void concat() throws Exception {
        Observable<Integer> seq1 = Observable.range(0, 3);
        Observable<Integer> seq2 = Observable.range(10, 3);

        Observable.concat(seq1, seq2)
                .subscribe(System.out::println);

    }

    @Test
    public void concat_1() throws Exception {

        Observable<String> words = Observable.just(
                "First",
                "Second",
                "Third",
                "Fourth",
                "Fifth",
                "Sixth"
        );

        Observable.concat(words.groupBy(v -> v.charAt(0)))
                .subscribe(System.out::println);

    }
}
