package com.waliahimanshu.courseracatalogue;


import org.junit.Test;

import io.reactivex.Observable;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class CoursesResponseUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void map_transforming_the_stream() throws Exception {
        Observable.just("Hello, world!")
                .map(s -> s + " -Dan")
                .subscribe(System.out::println);

    }

    @Test
    public void maps_alters_data_type_while_emitting() throws Exception {

//        Observable.just("Hello, world!")
//                .map(s -> s.hashCode())
//                .subscribe(i -> System.out.println(Integer.toString(i)));

        Observable.just("Hello, world!")
                .map(s -> s + " -Dan")
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i))
                .subscribe(s -> System.out.println(s));
    }
}