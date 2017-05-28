package com.waliahimanshu.courseracatalogue.ui.all_courses;

import com.flextrade.jfixture.FixtureAnnotations;
import com.flextrade.jfixture.annotations.Fixture;
import com.waliahimanshu.courseracatalogue.api.response_dto.Courses;
import com.waliahimanshu.courseracatalogue.api.response_dto.CoursesResponse;
import com.waliahimanshu.courseracatalogue.ui.all_courses.domain.CourseDetailsDomain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by waliahimanshu.
 */
public class CoursesDetailDomainMapperTest {

    private CoursesDetailDomainMapper sut;

    @Fixture private CoursesResponse fixtCourseraResponse;
    @Mock private LinkedPartnersMapper mockPartnerMapper;
    @Mock private LinkedInstructorMapper mockInstructorMapper;

    @Before
    public void setUp() throws Exception {
        FixtureAnnotations.initFixtures(this);
        sut = new CoursesDetailDomainMapper(mockInstructorMapper,mockPartnerMapper);

    }

    @Test
    public void mapCourseInfo() throws Exception {
        List<CourseDetailsDomain> expected = sut.apply(fixtCourseraResponse);

        Courses actual = fixtCourseraResponse.courses.get(0);
        CourseDetailsDomain expectedDomain = expected.get(0);

        assertThat(actual.courseType, is(expectedDomain.getCourseType()));
        assertThat(actual.id, is(expectedDomain.getId()));
        assertThat(actual.name, is(expectedDomain.getName()));
        assertThat(actual.slug, is(expectedDomain.getSlug()));
    }


    @Test
    public void mapInstructorName() throws Exception {
        fixtCourseraResponse.linked.instructors.get(0).name = "abcd";
        fixtCourseraResponse.linked.instructors.get(0).id = fixtCourseraResponse.courses.get(0).instructorIds.get(0);

        List<CourseDetailsDomain> expected = sut.apply(fixtCourseraResponse);

        CourseDetailsDomain expectedDomain = expected.get(0);

        assertThat("abcd", is(expectedDomain.getInstructorName().get(0).getName()));
    }

    @Test
    public void mapPartnerName() throws Exception {
        fixtCourseraResponse.linked.partners.get(0).name = "abcd";
        fixtCourseraResponse.linked.partners.get(0).id = fixtCourseraResponse.courses.get(0).partnerIds.get(0);

        List<CourseDetailsDomain> expected = sut.apply(fixtCourseraResponse);

        CourseDetailsDomain expectedDomain = expected.get(0);

        assertThat("abcd", is(expectedDomain.getPartnerName().get(0).getName()));
    }
}