package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;

import com.waliahimanshu.courseracatalogue.api.Response.Courses;
import com.waliahimanshu.courseracatalogue.api.Response.CoursesResponse;
import com.waliahimanshu.courseracatalogue.ui.home.CourseDetailsDomain;
import com.waliahimanshu.courseracatalogue.ui.home.MoreInfoDomain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

public class ResponseMapper implements Function<CoursesResponse, List<CourseDetailsDomain>> {

    private LinkedInstructorMapper instructorMapper;
    private LinkedPartnersMapper linkedPartnersMapper;

    @Inject
    public ResponseMapper(LinkedInstructorMapper instructorMapper, LinkedPartnersMapper linkedPartnersMapper) {
        this.instructorMapper = instructorMapper;
        this.linkedPartnersMapper = linkedPartnersMapper;
    }

    @Override
    public List<CourseDetailsDomain> apply(CoursesResponse courses) throws Exception {

        ArrayList<CourseDetailsDomain> courseDetailsDomains = new ArrayList<>();

        for (Courses course : courses.courses) {

            List<MoreInfoDomain> parternsId = linkedPartnersMapper.apply(course.partnerIds, courses.linked.partners);
            List<MoreInfoDomain> instructorIds = instructorMapper.apply(course.instructorIds, courses.linked.instructors);

            CourseDetailsDomain detailsDomain = new CourseDetailsDomain(
                    course.id,
                    course.courseType,
                    course.name,
                    course.slug,
                    parternsId,
                    instructorIds);
            courseDetailsDomains.add(detailsDomain);
        }
        return courseDetailsDomains;
    }
}
