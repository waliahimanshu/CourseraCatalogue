package com.waliahimanshu.courseracatalogue.ui.home;


import com.waliahimanshu.courseracatalogue.api.CourseraApiService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

public class CoursesResponseUnitTest {
    private SearchActivityPresenter sut;

    @Mock
    private SearchActivityContract.View mockView;
    @Mock
    private CourseraApiService mockApi;

    @Before
    public void setUp() throws Exception {
        sut = new SearchActivityPresenter(mockView, mockApi);
    }

    @Test
    public void initSubscribes() throws Exception {

    }
}
