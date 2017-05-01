package com.waliahimanshu.courseracatalogue.ui.home;


import com.waliahimanshu.courseracatalogue.api.CourseraApiService;
import com.waliahimanshu.courseracatalogue.ui.home.HomeFragmentContract;
import com.waliahimanshu.courseracatalogue.ui.home.HomeFragmentPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subscribers.TestSubscriber;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

public class CoursesResponseUnitTest {
    private HomeFragmentPresenter sut;

    @Mock
    private HomeFragmentContract.View mockView;
    @Mock
    private CourseraApiService mockApi;

    @Before
    public void setUp() throws Exception {
        sut = new HomeFragmentPresenter(mockView, mockApi);
    }

    @Test
    public void initSubscribes() throws Exception {

    }
}
